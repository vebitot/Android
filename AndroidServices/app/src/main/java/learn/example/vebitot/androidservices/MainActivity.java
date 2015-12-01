package learn.example.vebitot.androidservices;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import learn.example.vebitot.boundServices.BoundService;

public class MainActivity extends Activity {
    private static String TAG = "Client";
    private BoundService mService;
    private boolean mBound = false;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message  = (TextView) findViewById(R.id.message);
    }

    public void onTestService(View v){
        if(mBound){
            String serviceMessage = mService.theService();
            message.setText(serviceMessage);
        }else{
            message.setText("Service not initiated!");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart(){
        Log.i(TAG, "Initializing the bind of service...");
        try{
            super.onStart();
            Intent intent = new Intent(this,BoundService.class);
            bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
            Log.i(TAG,"Bind service initialized by client.");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();

    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder serviceName) {
            Log.i(TAG, "Service Connection callback received, getting the instance of the service...");
            BoundService.LocalBinder binder =  (BoundService.LocalBinder) serviceName;
            mService = binder.getBoundService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "Bound service disconnected!");
            message.setText("Service disconnected!");
            mBound = false;
        }
    };
}
