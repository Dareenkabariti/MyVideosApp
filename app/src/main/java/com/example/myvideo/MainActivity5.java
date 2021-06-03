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

public class MainActivity5 extends AppCompatActivity {
    String videoURL= "https://firebasestorage.googleapis.com/v0/b/jerusalemguid.appspot.com/o/videos%2FNature%20Beautiful%20short%20video%20720p%20HD.mp4?alt=media&token=75c1ffe0-c9c1-4683-b4d8-9acb6186508e";
    PlayerView playerView;
    SimpleExoPlayer player;
    private  boolean playWhenReady = true;
    private  int currentWindow = 0;
    private  long playBackPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        playerView = findViewById(R.id.video_view4);
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