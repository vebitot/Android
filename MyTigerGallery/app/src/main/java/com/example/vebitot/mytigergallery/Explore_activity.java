package com.example.vebitot.mytigergallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Explore_activity extends AppCompatActivity {
    private static String TAG = "Log-Filter";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_explore_activity);
            ListView listview = (ListView) findViewById(R.id.explore_list_view);
            Bind_adapter bind_adapter = new Bind_adapter(this,R.layout.explore_list_row,MainActivity.myTigers);
            listview.setAdapter(bind_adapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent list_data_intent = new Intent();
                    list_data_intent.setClass(getApplicationContext(), details_activity.class);
                    list_data_intent.putExtra(Extra_Params.LIST_ITEM_DATA_INDEX, position);
                    startActivity(list_data_intent);
                }
            });
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explore_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
