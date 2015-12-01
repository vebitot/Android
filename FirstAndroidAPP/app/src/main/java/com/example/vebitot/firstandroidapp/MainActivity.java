package com.example.vebitot.firstandroidapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    private static String TAG ="Logger";
    static int index = 1;
    static Map<String, Object> myTigers = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Provides a window
         */
        super.onCreate(savedInstanceState);
        /**
         * Setting the UI page to the activity
         * R.layout.activity_main -> Resource/layout/activity_main.xml
         */
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.next);
        Button previous = (Button) findViewById(R.id.previous);
        final ImageView image = (ImageView) findViewById(R.id.tiger1);
        Log.i(TAG, "onCreate");
        myTigers.put("The Siberian Tiger", 0);
        myTigers.put("The Sumatran Tiger", 1);
        myTigers.put("The South China Tiger",2);
        myTigers.put("The Bengal Tiger",3);
        myTigers.put("The Malayan Tiger",4);
        
        final int[] gallery = new int[5];
        gallery[0] = R.drawable.t1;
        gallery[1] = R.drawable.t2;
        gallery[2] = R.drawable.t3;
        gallery[3] = R.drawable.t4;
        gallery[4] = R.drawable.t5;
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(index == 5)
              {
                  index = 0;
              }
                image.setImageResource(gallery[index++]);
            }
        });
        previous.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(index == -1)
                {
                    index = 4;
                }
                image.setImageResource(gallery[index--]);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Log.i(TAG,"Image clicked, starting new activity");
                    Intent detail_Intent = new Intent();
                    detail_Intent.setClass(getApplicationContext(),GetImageDetails.class);
                    detail_Intent.putExtra("ImageUrl", index-1);
                    detail_Intent.putExtra("Gallery", gallery);
                    startActivity(detail_Intent);
                }catch (Exception ex){
                    Log.i(TAG,"Exception occurred, could not start activity");
                    Log.i(TAG,ex.toString());
                }
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(TAG, "onPostResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
