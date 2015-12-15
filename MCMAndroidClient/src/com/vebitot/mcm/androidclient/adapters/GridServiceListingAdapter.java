package com.vebitot.mcm.androidclient.adapters;

import java.util.ArrayList;

import com.vebitot.mcm.androidclient.R;
import com.vebitot.mcm.androidclient.constants.Constants;
import com.vebitot.mcm.androidclient.models.ServiceCategory;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.LayoutInflater;

public class GridServiceListingAdapter extends BaseAdapter {

	private ArrayList<ServiceCategory> data;
	LayoutInflater inflater;
	Context context;
	/**
	 * The layout resource id to inflate
	 */
	int resource;
	
	public GridServiceListingAdapter(Context context, int resource, ArrayList<ServiceCategory> data) {
		this.data = data;
		this.context = context;
		this.resource = resource;
	}
	/**
	 * Need to return the size of the data inorder for the application to invoke the getView method
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vi;
		Log.d(Constants.LOG_TAG,"Getting view for grid view...");
		if (convertView == null) {
			Log.i(Constants.LOG_TAG, "ConvertView is NULL, setting it to the row example");
			vi = inflater.inflate(R.layout.service_types_layout, null);
		}else{
			vi = convertView;
		}
		TextView serviceType = (TextView) vi.findViewById(R.id.service_type);
		ServiceCategory category = data.get(position);
		serviceType.setText(category.getmServiceType());
		
		ImageView imageView = (ImageView) vi.findViewById(R.id.service_type_img);
		if(imageView==null){
			Toast.makeText(this.context, "ImageView is still null :(", Toast.LENGTH_SHORT).show();
		}else{
			imageView.setImageResource(R.drawable.service_pc);	
		}
		return vi;
	}
}
