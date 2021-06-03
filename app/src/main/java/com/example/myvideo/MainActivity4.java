package com.example.myvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class MainActivity4 extends AppCompatActivity {
    String videoURL= "https://firebasestorage.googleapis.com/v0/b/jerusalemguid.appspot.com/o/videos%2FNo%20Copyright%20Video%20Stock%20__%20Amazing%20Collection%20of%20%20Nature%20__%20Free%20Nature%20Videos.mp4?alt=media&token=9f534b1a-e438-487a-8a9e-98b5f085b88f";
    PlayerView playerView;
    SimpleExoPlayer player;
    private  boolean playWhenReady = true;
    private  int currentWindow = 0;
    private  long playBackPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        playerView = findViewById(R.id.video_view3);
    }

    public void initVideo(){
        player = ExoPlayerFactory.newSimpleInstance(this);
        playerView.setPlayer(player);

        Uri uri = Uri.parse(videoURL);
        DataSource.Factory dataSource = new DefaultDataSourceFactory(this,"exoplayer-codelab");

        MediaSource mediaSource = new ProgressiveMediaSource.Factory(dataSource).createMediaSource(uri);
        player.setPlayWhenReady(playWhenReady);
        player.seekTo(currentWindow,playBackPosition);
        player.prepare(mediaSource,false,false);
        float currentVolume = player.getVolume();

    }
    public void releaseVideo(){
        if (player !=null){
            playWhenReady= player.getPlayWhenReady();
            playBackPosition = player.getCurrentPosition();
            currentWindow = player.getCurrentWindowIndex();
            float currentVolume = player.getVolume();
            if (currentVolume == 0f) {
                player.setVolume(1f);
            } else {
                player.setVolume(0f);
            }
            player.release();
            player = null;
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        initVideo();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (player != null){
//            initVideo();
//        }
//    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseVideo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseVideo();
    }
}