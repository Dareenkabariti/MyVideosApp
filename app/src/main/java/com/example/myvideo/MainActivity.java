package com.example.myvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class MainActivity extends AppCompatActivity {
    LinearLayout v1,v2,v3,v4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1 = findViewById(R.id.v1);
        v2 = findViewById(R.id.v2);
        v3 = findViewById(R.id.v3);
        v4 = findViewById(R.id.v4);


        v1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoURL="https://firebasestorage.googleapis.com/v0/b/jerusalemguid.appspot.com/o/videos%2FBeautiful%20Sunrise%20Video%20with%20birds%20_%20Early%20morning%20time%20Lapse.mp4?alt=media&token=352ec824-7ac9-4d02-9c4c-d8b6d3e7fb70";

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url",videoURL);
                startActivity(intent);
            }
        });
        v2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoURL= "https://firebasestorage.googleapis.com/v0/b/jerusalemguid.appspot.com/o/videos%2FA%20short%20natural%20video.mp4?alt=media&token=356745d8-3f3d-484c-8def-38e335cdf331";

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url",videoURL);

                startActivity(intent);
            }
        });
        v3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoURL= "https://firebasestorage.googleapis.com/v0/b/jerusalemguid.appspot.com/o/videos%2FNo%20Copyright%20Video%20Stock%20__%20Amazing%20Collection%20of%20%20Nature%20__%20Free%20Nature%20Videos.mp4?alt=media&token=9f534b1a-e438-487a-8a9e-98b5f085b88f";

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url",videoURL);

                startActivity(intent);
            }
        });
        v4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoURL= "https://firebasestorage.googleapis.com/v0/b/jerusalemguid.appspot.com/o/videos%2FNature%20Beautiful%20short%20video%20720p%20HD.mp4?alt=media&token=75c1ffe0-c9c1-4683-b4d8-9acb6186508e";

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("url",videoURL);

                startActivity(intent);
            }
        });
    }


}