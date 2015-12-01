package com.example.vebitot.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by vebitot on 19-08-2015.
 */
public class GetImageDetails extends Activity{
    private static String TAG ="Logger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_details);
        Log.i(TAG,"ImageId received from caller");
        try{
            int index = getIntent().getExtras().getInt("ImageUrl");
            int[] gallery = (int[]) getIntent().getExtras().get("Gallery");
            ImageView image = (ImageView) findViewById(R.id.breed_image);
            image.setImageResource(gallery[index]);
        }catch (Exception ex){
            Log.i(TAG, ex.toString());
        }

        Button backButton = (Button) findViewById(R.id.bckBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.index = 0;
                Intent homeIntent = new Intent();
                homeIntent.setClass(getApplicationContext(),MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
