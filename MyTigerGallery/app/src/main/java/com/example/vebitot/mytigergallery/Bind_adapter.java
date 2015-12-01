package com.example.vebitot.mytigergallery;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

/**
 * Created by vebitot on 21-08-2015.
 */
public class Bind_adapter extends ArrayAdapter<MainActivity.MyTigers>{
    private static String TAG = "Log-Filter";
        LayoutInflater inflater;
        int layoutResourceId;
        Context context;
        List<MainActivity.MyTigers> data;

    public Bind_adapter(Context context, int resource, List<MainActivity.MyTigers> data) {
        super(context, resource, data);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = data;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        /**
         * Getting the current list item data
         */
        MainActivity.MyTigers tiger = data.get(position);
        View vi = convertView;
        if(convertView==null)
        {
            Log.i(TAG,"ConvertView is NULL, setting it to the row example");
            vi = inflater.inflate(R.layout.explore_list_row, null);
        }
        ImageView img = (ImageView) vi.findViewById(R.id.img);
        TextView txtView = (TextView) vi.findViewById(R.id.name);
        img.setImageResource(tiger.imageResourceIconId);
        txtView.setText(tiger.name);
        return vi;
    }
}
