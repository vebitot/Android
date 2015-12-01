package learn.example.vebitot.boundwithmessenger;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Client extends AppCompatActivity {
    private static final String TAG = "MessengerService";
    private Messenger mService = null;
    boolean mBounded = false;

    private static final int MESSAGE_REPLY = 105;

    private TextView messageTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        messageTV = (TextView) findViewById(R.id.message);
    }

    /**
     * Service connection to interact with the main interface of service
     */
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        /**
         * Callback method from the Service Binder once the bind is completed
         * In this case, client sends a replyTo object to the Service so that
         * it can also send messages to the client using the replyTo object (Messenger)
         * @param name
         * @param service
         */
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "Service connected successfully.");
            Toast.makeText(getApplicationContext(),"Service connected!",Toast.LENGTH_SHORT).show();
            mService = new Messenger(service);
            Message clientMessage =  new Message();
            clientMessage.replyTo = mClientMessenger;
            clientMessage.what = Server.REGISTER_CLIENT;
            try{
                Toast.makeText(getApplicationContext(),"Registering the client messenger",Toast.LENGTH_SHORT).show();
                mService.send(clientMessage);
            }catch (RemoteException ex){
                ex.printStackTrace();
            }
            mBounded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG,"Service disconnected.");
            Toast.makeText(getApplicationContext(),"Service disconnected!",Toast.LENGTH_SHORT).show();
            mService = null;
            mBounded = false;
        }
    };

    @Override
    protected void onStart(){
        Log.i(TAG,"Activity started, binding to service now... ");
        super.onStart();
        bindService(new Intent(this, Server.class), mServiceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop(){
        Log.i(TAG, "Activity stopped, unbinding the service...");
        super.onStop();
        if(mBounded){
            if(mService != null){
                Message msg = Message.obtain(null,Server.REMOVE_CLIENT);
                msg.replyTo = mClientMessenger;
                try{
                    mService.send(msg);
                }catch (RemoteException ex){
                    ex.printStackTrace();
                }
            }
            unbindService(mServiceConnection);
            mBounded = false;
        }
    }

    public void onRead(View view){
        if(mBounded){
            Message msg = Message.obtain(null,Server.INSTRUCTION_READ,0,0);
            try{
                mService.send(msg);
            }catch (RemoteException ex){
                ex.printStackTrace();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Service not connected!",Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void onWrite(View view){
        if(mBounded){
            Message msg = Message.obtain(null,Server.INSTRUCTION_WRITE,0,0);
            try{
                msg.obj = "Message overwritten by write service";
                mService.send(msg);
            }catch (RemoteException ex){
                ex.printStackTrace();
            }
        }else{
            Toast.makeText(getApplicationContext(),"Service not connected!",Toast.LENGTH_SHORT).show();
            return;
        }
    }

    /**
     * Client Messenger which will be used by the server to send reply messages to the client
     */
    class ClientMessageHandler extends Handler {
        /**
         * Method for handling the messages from the Service activity
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "Message reply received from server", Toast.LENGTH_SHORT).show();
            switch (msg.what) {
                case Server.INSTRUCTION_READ:
                    messageTV.setText("Received from service: " + msg.obj.toString());
                    break;
                case Server.INSTRUCTION_WRITE:
                    messageTV.setText("Received from service: " + msg.obj.toString());
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
    private final Messenger mClientMessenger = new Messenger(new ClientMessageHandler());
}
