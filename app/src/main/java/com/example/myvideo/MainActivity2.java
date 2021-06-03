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

import static android.media.tv.TvTrackInfo.TYPE_AUDIO;
import static android.media.tv.TvTrackInfo.TYPE_VIDEO;

public class MainActivity2 extends AppCompatActivity {
    String videoURL="https://firebasestorage.googleapis.com/v0/b/jerusalemguid.appspot.com/o/videos%2FBeautiful%20Sunrise%20Video%20with%20birds%20_%20Early%20morning%20time%20Lapse.mp4?alt=media&token=352ec824-7ac9-4d02-9c4c-d8b6d3e7fb70";
    PlayerView playerView;
    SimpleExoPlayer player;
    private  boolean playWhenReady = true;
    private  int currentWindow = 0;
    private  long playBackPosition = 0;
    float currentVolume ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
     //   int currentVolume = (int) player.getAudioComponent().getVolume();
        playerView = findViewById(R.id.video_view1);
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