package learn.example.vebitot.boundServices;

import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
/**
 * A example of a bound service extending the Service class
 * Created by vebitot on 30-11-2015.
 */
public class BoundService extends Service{
    private static String TAG = "Client";
    private final String mServiceMessage = "WELCOME TO THE SERVICE";

    private final IBinder mBinder = new LocalBinder();


    public class LocalBinder extends Binder{
        /**
         * Returns this instance of the BoundService so that clients can call its public methods.
         * @return BoundService
         */
        public BoundService getBoundService(){
            Log.i(TAG,"Service instance requested!");
            return BoundService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent){
        Log.i(TAG,"Service bind initiated!");
        return mBinder;
    }

    /**
     * The service which will be consumed by the client(s)
     * @return
     */
    public String theService(){
        Log.i(TAG,"Service utilized!");
        return this.mServiceMessage;
    }

}
