package com.example.vebitot.mytigergallery;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.w3c.dom.Text;

public class details_activity extends YouTubeFailureRecoveryActivity{
    private static String TAG="Log-Filter";
    private static final int RECOVERY_DIALOG_REQUEST = 1;
    protected static String tiger_detail_url;
    protected static String tiger_video_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_details);
            ImageView img = (ImageView) findViewById(R.id.tiger_details_img);
            TextView txtView = (TextView) findViewById(R.id.description);
            int position = getIntent().getIntExtra(Extra_Params.LIST_ITEM_DATA_INDEX,0);
            MainActivity.MyTigers tiger = MainActivity.myTigers.get(position);
            img.setImageResource(tiger.imageResourceId);
            txtView.setText(tiger.description);
            tiger_detail_url = getString(tiger.resourceUrl);
            tiger_video_url = getString(tiger.resourceVideoUrl);
            YouTubePlayerView youTube = (YouTubePlayerView) findViewById(R.id.youtube_view);
            youTube.initialize(DeveloperKey.API_KEY,this);
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }

        final Button explore_more_btn = (Button) findViewById(R.id.explore_more_btn);
        explore_more_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent explore_more_intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tiger_detail_url));
                startActivity(explore_more_intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details_activity, menu);
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

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {
        Log.i(TAG,"You Tube API initialize successfully");
        if (!wasRestored) {
            player.cueVideo(tiger_video_url);
        }
    }

    @Override
    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }
}
