package com.vebitot.mcm.androidclient;

import com.vebitot.mcm.androidclient.constants.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;

public class Splash extends Activity {

	// The splash screen timeout period set to 2000mS
	private static final int mSPLASH_TIMEOUT = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(Constants.LOG_TAG, "Application started!");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		getActionBar().hide();
		/**
		 * All dynamic assets will be downloaded while the splash screen is displayed.
		 */
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Log.d(Constants.LOG_TAG,
						"Splash screen timed out, starting the main activity");
				Intent i = new Intent(Splash.this, MainActivity.class);
				startActivity(i);
				finish();
			}
		}, mSPLASH_TIMEOUT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}
}
