package com.example.cahv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Television extends AppCompatActivity {

    Button video1, video2, video3, pausa, reproducir;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_television);


        video1 = findViewById(R.id.btnTV1);
        video1.setOnClickListener(view -> {
            video=(VideoView) findViewById(R.id.vistaVideo);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.video1;
            video.setVideoURI(Uri.parse(path));
            video.start();
        });

        video2 = findViewById(R.id.btnTV2);
        video2.setOnClickListener(view -> {
            video=(VideoView) findViewById(R.id.vistaVideo);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.vid2;
            video.setVideoURI(Uri.parse(path));
            video.start();
        });

        video3 = findViewById(R.id.btnTV3);
        video3.setOnClickListener(view -> {
            video=(VideoView) findViewById(R.id.vistaVideo);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.vid3;
            video.setVideoURI(Uri.parse(path));
            video.start();
        });

        pausa = findViewById(R.id.btnPausa);
        pausa.setOnClickListener(view -> pausa());

        reproducir = findViewById(R.id.btnPlay);
        reproducir.setOnClickListener(view -> reproducir());

    }

    public void pausa(){
        video.pause();
    }

    public void reproducir(){
        video.start();
    }
}