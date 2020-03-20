package com.example.hindi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numbersText = (TextView)findViewById(R.id.NumbersText);
        TextView coloursText = (TextView)findViewById(R.id.ColoursText);
        TextView familyText = (TextView)findViewById(R.id.FamilyText);
        TextView phrasesText = (TextView)findViewById(R.id.PhrasesText);

        //created the onClickListener inline, instead of creating a new class for it
        numbersText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this,
                        NumbersActivity.class);

                startActivity(numbersIntent);
            }
        });

        coloursText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent coloursIntent = new Intent(MainActivity.this,
                        ColoursActivity.class);

                startActivity(coloursIntent);
            }
        });

        familyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent(MainActivity.this,
                        FamilyActivity.class);

                startActivity(familyIntent);
            }
        });

        phrasesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent = new Intent(MainActivity.this,PhrasesActivity.class);

                startActivity(phrasesIntent);
            }
        });

        Button playButton = findViewById(R.id.playButton);
        Button pauseButton = findViewById(R.id.pauseButton);
        mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.phrase_how_are_you_feeling);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.start();

            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMediaPlayer.pause();
            }
        });

        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mMediaPlayer) {
                Toast.makeText(MainActivity.this,"Playback Stopped",Toast.LENGTH_SHORT).show();
            }
        });


    }




}
