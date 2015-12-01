package com.example.vebitot.mytigergallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static String TAG ="Log-Filter";
    static int index = 1;
    static List<MyTigers> myTigers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_main);
            if(myTigers.size() <= 0)
            {
                initializeData();
            }
            Button button = (Button) findViewById(R.id.explore_btn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent explore_intent = new Intent();
                    explore_intent.setClass(getApplicationContext(), Explore_activity.class);
                    startActivity(explore_intent);
                }
            });

        }catch (Exception ex)
        {
            Log.e(TAG,ex.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    private void initializeData(){
        Log.i(TAG, "Application launched, setting up startup data...");
        myTigers.add(new MyTigers("The Siberian Tiger", R.drawable.the_siberian_tiger,
                R.drawable.sib_icon, R.string.siberian_desc, R.string.sib_tiger_url,
                R.string.sib_tiger_video_url));
        myTigers.add(new MyTigers("The Sumatran Tiger", R.drawable.sumatran_tiger,
                R.drawable.sum_ico, R.string.sumatran_desc, R.string.sum_tiger_url,
                R.string.sum_tiger_video_url));
        myTigers.add(new MyTigers("The South China Tiger", R.drawable.south_china_tiger,
                R.drawable.chi_ico,R.string.china_desc,R.string.chin_tiger_url,
                R.string.chin_tiger_video_url));
        myTigers.add(new MyTigers("The Bengal Tiger", R.drawable.bengal_tiger,
                R.drawable.bengal_ico,R.string.bengal_desc,R.string.ben_tiger_url,
                R.string.ben_tiger_video_url));
        myTigers.add(new MyTigers("The Malayan Tiger", R.drawable.malayan_tiger,
                R.drawable.mail_ico,R.string.malayan_desc,R.string.mal_tiger_url,
                R.string.mal_tiger_video_url));
    }
    class MyTigers{
        String name;
        int imageResourceId;
        int imageResourceIconId;
        int description;
        int resourceUrl;
        int resourceVideoUrl;
        MyTigers(String name, int resId, int imageResourceIconId, int description,int resourceUrl, int resourceVideoUrl)
        {
            this.name = name;
            this.imageResourceId = resId;
            this.imageResourceIconId = imageResourceIconId;
            this.description = description;
            this.resourceUrl = resourceUrl;
            this.resourceVideoUrl = resourceVideoUrl;
        }
    }
}
