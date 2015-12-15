package com.vebitot.mcm.androidclient.workers;

import java.net.URL;
import java.util.ArrayList;

import com.vebitot.mcm.androidclient.models.Services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Rating;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * This AsyncTask will be used for initializing services data
 * 
 * @author vebitot
 */
public class DataInitializer extends AsyncTask<URL, Integer, ArrayList<Services>> {
	private Context mAppContext;
	private IAsyncResponse mAsyncResponse;
	public DataInitializer(Context context, IAsyncResponse asyncResp) {
		this.mAppContext = context;
		this.mAsyncResponse = asyncResp;
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	};

	@SuppressWarnings("unused")
	@SuppressLint("InlinedApi")
	@Override
	protected ArrayList<Services> doInBackground(URL... params) {
		if (true) {
			ArrayList<Services> availableServices = new ArrayList<Services>();
			Services service = new Services();
			service.setmServiceName("Mojo WoodWorks");
			service.setmRating(Rating.RATING_4_STARS);
			service.setmServiceDescription("Mojo WoodWorks is a well recognized woodwork service known for the quality and opulance feel of its products. MWw works on varied"
					+ " home products from furnitures to cabinets to door and window panels and many many more.");
			service.setmServiceOwner("Mojo");
			service.setmSpecilization("Carpentry");
			service.setmServiceType("Wood Works");
			
			Services service2 = new Services();
			service2.setmServiceName("Megh Bakes");
			service2.setmRating(Rating.RATING_4_STARS);
			service2.setmServiceDescription("Megh Bakes is an example of pure passion and love manifested in the form of a baked food product. Megh Bakes owner Miss.Megh is specially enthusiatic about seeing the smile and satisfaction on the faces"
					+ "of her customers when they receivce their order. Megh bakes believes in more than just a satisfied customer, they believe in a 'Thrilled' customer experience!");
			service2.setmServiceOwner("Miss.Megh");
			service2.setmSpecilization("Food Products");
			service2.setmServiceType("Food Products");
			availableServices.add(service2);
			availableServices.add(service);
			return availableServices;
		} else {
			return null;
		}

	}

	protected void onPostExecute(ArrayList<Services> result) {
		Toast.makeText(mAppContext, "Data loaded!", Toast.LENGTH_SHORT).show();
		this.mAsyncResponse.executionComplete(result);
	}
}
