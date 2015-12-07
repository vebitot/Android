package learn.example.vebitot.sharedservice;

import android.app.Service;
import android.content.Intent;
import android.os.*;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

/**
 * Created by vebitot on 04-12-2015.
 */
public class RemoteServiceImpl extends Service {
    private static final String TAG = "AIDL_SAMPLE";

    @Override
    public void onCreate() {
        Log.i(TAG, "Remote service created!");
        super.onCreate();
    }

    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
        @Override
        public int getRandomId() throws RemoteException {
            Log.i(TAG, "getRandomId service requested!");
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100000);
            return randomInt;
        }

        @Override
        public int getPID() throws RemoteException {
            Log.i(TAG, "getPID service requested!");
            return android.os.Process.myPid();
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}



