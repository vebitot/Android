package com.vebitot.mcm.androidclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.vebitot.mcm.androidclient.adapters.GridServiceListingAdapter;
import com.vebitot.mcm.androidclient.constants.Constants;
import com.vebitot.mcm.androidclient.models.ServiceCategory;
import com.vebitot.mcm.androidclient.workers.IAsyncResponse;
import com.vebitot.mcm.androidclient.workers.ServicesMetaInitialization;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.util.Log;

public class MainActivity extends Activity {

	private ArrayList<ServiceCategory> serviceCategories;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(Constants.LOG_TAG,
				"Main activity created, initializing grid data!");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().hide();
//		initializeServiceData();
		GridView gridView = (GridView) findViewById(R.id.service_types_grid);
		GridServiceListingAdapter gridAdapter = new GridServiceListingAdapter(
				getApplicationContext(), R.layout.service_types_layout,
				initdata());

		Log.d(Constants.LOG_TAG,"Grid adapter initialized!");
		gridView.setAdapter(gridAdapter);
		
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), position,
						Toast.LENGTH_SHORT);
			}
		});
/*		Log.d(Constants.LOG_TAG,"Grid adapter initialized!");
		GridView gridView = (GridView) findViewById(R.id.service_types_grid);
		GridServiceListingAdapter gridAdapter = new GridServiceListingAdapter(
				getApplicationContext(), R.layout.service_types_layout,
				serviceCategories);
		Log.d(Constants.LOG_TAG,"Grid adapter initialized!");
		gridView.setAdapter(gridAdapter);
		Log.d(Constants.LOG_TAG,"Grid adapter initialized!");
		gridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getApplicationContext(), position,
						Toast.LENGTH_SHORT);
			}
		});*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * Initializes the grid data for listing the services
	 */
	public void initializeServiceData() {
		try {
			/*
			 * DataInitializer dataInzer = new DataInitializer(
			 * getApplicationContext(), new IAsyncResponse() {
			 * 
			 * @SuppressWarnings("unchecked")
			 * 
			 * @Override public void executionComplete(Object result) {
			 * availableServices = (ArrayList<Services>) result; } });
			 */
			ServicesMetaInitialization serviceMetaInit = new ServicesMetaInitialization(
					getApplicationContext(), new IAsyncResponse() {

						@SuppressWarnings("unchecked")
						@Override
						public void executionComplete(Object result) {
							MainActivity.this.serviceCategories = (ArrayList<ServiceCategory>) result;
 							Log.d(Constants.LOG_TAG, "Datas inserted : "
									+ serviceCategories.size());
							
						}
					});
			serviceMetaInit.execute(new URL("https://getMCMData.com"));
			Log.d(Constants.LOG_TAG,"1!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	protected ArrayList<ServiceCategory> initdata() {
		ServiceCategory serviceCat = new ServiceCategory();
		ServiceCategory serviceCat2 = new ServiceCategory();
		serviceCat2.setmServiceType("Food Products");
		serviceCat2.setmServiceTypeLogo("service_pc.png");
		serviceCat2.setmDescription("Provides catering services, baking and party orders.");
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("re-furnishing");
		tags.add("carpentry");
		serviceCat2.setTags(tags);
		serviceCat.setmServiceType("Wood Works");
		serviceCat.setmDescription("Wood works provide services such as carpentry, home wood furnishing, etc.");
		serviceCat.setmServiceTypeLogo("wood_works.png");
		tags.remove(0);
		tags.remove(0);
		tags.add("baking");
		tags.add("catering");
		serviceCat.setTags(tags);
		ArrayList<ServiceCategory> serviceCategories = new ArrayList<ServiceCategory>();
		serviceCategories.add(serviceCat2);
		serviceCategories.add(serviceCat);
		serviceCategories.addAll(serviceCategories);
		return serviceCategories;
	}
}
