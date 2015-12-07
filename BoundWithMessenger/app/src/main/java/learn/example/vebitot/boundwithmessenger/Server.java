package learn.example.vebitot.boundwithmessenger;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import android.widget.Toast;
import android.os.Process;

/**
 * Created by vebitot on 01-12-2015.
 */
public class Server extends Service {

    public static final int INSTRUCTION_READ = 101;
    public static final int INSTRUCTION_WRITE = 102;
    public static final int REGISTER_CLIENT = 80;
    public static final int REMOVE_CLIENT = 81;

    private static final int MESSAGE_REPLY = 105;

    private String mServiceNote = "Welcome to the Service";

    private Messenger mClientMessenger = null;
    /**
     * Message Handler for incoming message from the client(s)
     */
    class MessageHandler extends Handler{
        @Override
        public void handleMessage(Message message){
            switch (message.what){
                case INSTRUCTION_READ :
                    try{
                        Message clientMessage = Message.obtain(null, INSTRUCTION_READ, 0, 0);
                        clientMessage.obj = mServiceNote;
                        mClientMessenger.send(clientMessage);
                    }catch (RemoteException ex){
                        ex.printStackTrace();
                        mClientMessenger = null;
                    }
                    break;
                case INSTRUCTION_WRITE :
                    mServiceNote = message.obj.toString();
                    try{
                        Message clientMessage = Message.obtain(null, INSTRUCTION_WRITE,0,0);
                        clientMessage.obj = "Write successful!";
                        mClientMessenger.send(clientMessage);
                    }catch (RemoteException ex){
                        ex.printStackTrace();
                        mClientMessenger = null;
                    }
                    break;
                case REGISTER_CLIENT :
                    mClientMessenger = message.replyTo;
                    Toast.makeText(getApplicationContext(),"Client messenger registered!",Toast.LENGTH_SHORT).show();
                    break;
                case REMOVE_CLIENT :
                    Toast.makeText(getApplicationContext(),"Removing client",Toast.LENGTH_SHORT).show();
                    mClientMessenger = null;
                    break;
                default:
                    super.handleMessage(message);
            }
        }
    }

    /**
     * The message target which will be published to the clients to send the messages.
     */
    final Messenger mMessenger = new Messenger(new MessageHandler());

    @Override
    public IBinder onBind(Intent intent){
        Toast.makeText(getApplicationContext(),"service bind initiated",Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }

    /**
     * Returns the process ID of the service
     * @return int PID
     */
    public int getPID(){
        return Process.myPid();
    }
}
