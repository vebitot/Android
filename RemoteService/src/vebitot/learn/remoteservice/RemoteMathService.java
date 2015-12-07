package vebitot.learn.remoteservice;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

public class RemoteMathService extends Service{
	private static final String TAG = "REMOTE_SERVICE_TRYOUT_LOGS";
	
	private final IRemoteMathService.Stub mBinder = new IRemoteMathService.Stub() {
		
		@Override
		public int getRandomId() throws RemoteException {
			Toast.makeText(getApplicationContext(),"Service requested!", Toast.LENGTH_SHORT).show();
			Random randomGenerator = new Random();
			int randomNumber = randomGenerator.nextInt(10000);
			return randomNumber;
		}
		
		@Override
		public int getPID() throws RemoteException {
			Toast.makeText(getApplicationContext(),"Service requested!", Toast.LENGTH_SHORT).show();
			return Process.myPid();
		}
	};
	
	@Override
	public void onCreate() {
		Log.i(TAG,"RemoteMath Services created!");
		Toast.makeText(getApplicationContext(),"Service created!", Toast.LENGTH_SHORT).show();
		super.onCreate();
	};
	
	@Override
	public IBinder onBind(Intent intent) {
		Toast.makeText(getApplicationContext(),"Bind request arrieved!", Toast.LENGTH_SHORT).show();
		return mBinder;
	}

}
