package vebitot.learn.mather;

import vebitot.learn.remoteservicetest.IRemoteMathService;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final String TAG = "REMOTE_SERVICE_TRYOUT_LOGS";

	private IRemoteMathService mMathService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onStart() {
		Log.i(TAG, "Services started, initiating bind to services...");
		super.onStart();
		initiateBindService();
	}
	
	private void initiateBindService(){
		Intent intent = new Intent(MainActivity.this,IRemoteMathService.class);
		if (intent != null && mServiceConnection != null) {
			Toast.makeText(getApplicationContext(),
					"Initating bind to service!", Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(),"Service bind successful : " + bindService(intent, mServiceConnection, Service.BIND_AUTO_CREATE),Toast.LENGTH_SHORT).show();
		}
	}

	private final ServiceConnection mServiceConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i(TAG, "Remote service disconnected");
			Toast.makeText(getApplicationContext(), "Service disconnected!",
					Toast.LENGTH_SHORT).show();
			mMathService = null;
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(TAG, "Remote service connected");
			Toast.makeText(getApplicationContext(), "Service connected!",
					Toast.LENGTH_SHORT).show();
			mMathService = IRemoteMathService.Stub.asInterface(service);
		}
	};

	public void OnGetRandom(View v) {
		if (mMathService != null) {
			try {
				int randomNum = mMathService.getRandomId();
				Toast.makeText(getApplicationContext(),
						"Generated random number : " + randomNum,
						Toast.LENGTH_SHORT).show();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} else {
			Toast.makeText(getApplicationContext(), "Service not initiated...",
					Toast.LENGTH_SHORT).show();
		}
	}

	public void onGetPID(View v) {
		if (mMathService != null) {
			try {
				int PID = mMathService.getPID();
				Toast.makeText(getApplicationContext(),
						"Remote Service PID :: " + PID, Toast.LENGTH_SHORT)
						.show();
			} catch (RemoteException ex) {
				ex.printStackTrace();
			}
		} else {
			Toast.makeText(getApplicationContext(), "Service not initiated...",
					Toast.LENGTH_SHORT).show();
		}

	}
}
