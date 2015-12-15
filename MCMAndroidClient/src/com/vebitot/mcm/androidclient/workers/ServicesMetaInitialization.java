package com.vebitot.mcm.androidclient.workers;

import java.net.URL;
import java.util.ArrayList;

import com.vebitot.mcm.androidclient.models.ServiceCategory;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Asynctask for fetching the categories of services avaiable currently.
 * @author vebitot
 */
public class ServicesMetaInitialization extends AsyncTask<URL, Integer, ArrayList<ServiceCategory>>{

	private Context mAppContext;
	private IAsyncResponse mAsyncResp;
	
	public ServicesMetaInitialization(Context context, IAsyncResponse asyncResp) {
		this.mAppContext = context;
		this.mAsyncResp = asyncResp;
	}
	/**
	 * This will actually make an API call to get the list of categories of services available
	 */
	@Override
	protected ArrayList<ServiceCategory> doInBackground(URL... params) {
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
		return serviceCategories;
	}
	
	protected void onPostExecute(ArrayList<ServiceCategory> result){
		Toast.makeText(mAppContext, "Data loaded!", Toast.LENGTH_SHORT).show();
		this.mAsyncResp.executionComplete(result);
	}
	

}
