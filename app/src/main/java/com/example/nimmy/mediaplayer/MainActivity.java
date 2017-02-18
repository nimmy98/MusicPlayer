package com.example.nimmy.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView textView;
    private MediaPlayer mp;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playSong();
    }

    public void playSong() {
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        textView = (TextView) findViewById(R.id.textView);
        imageView = (ImageView)findViewById(R.id.imagview);
        imageView.setImageResource(R.drawable.arjit);
         mp = MediaPlayer.create(MainActivity.this,R.raw.music);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    mp.start();
                } else {
                    mp.pause();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mp !=null) {
            mp.release();
            mp = null;
        }
    }
}