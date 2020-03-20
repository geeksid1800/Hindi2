package com.example.hindi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ListView listView = findViewById(R.id.list);

        final ArrayList<Words> wordsList = new ArrayList<Words>();

        //Can also be:
        // Words w = new Words("Ek","One",R.drawable.number_one);     //using constructor overloading to use the 3-argument constr.
        //wordsList.add(w);
        //note here we're not adding the image itself, we're adding the ID of the image, which is an integer
        wordsList.add(new Words("red", "weṭeṭṭi", R.drawable.color_red,R.raw.color_red));
        wordsList.add(new Words("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        wordsList.add(new Words("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        wordsList.add(new Words("green", "chokokki", R.drawable.color_green,R.raw.color_green));
        wordsList.add(new Words("brown", "ṭakaakki", R.drawable.color_brown,R.raw.color_brown));
        wordsList.add(new Words("gray", "ṭopoppi", R.drawable.color_gray,R.raw.color_gray));
        wordsList.add(new Words("black", "kululli", R.drawable.color_black,R.raw.color_black));
        wordsList.add(new Words("white", "kelelli", R.drawable.color_white,R.raw.color_white));



        WordsAdapter adapter = new WordsAdapter(this, wordsList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words my_word = wordsList.get(position); //get the object at specific position from ListView
                MediaPlayer mMediaPlayer = MediaPlayer.create(ColoursActivity.this,my_word.getAudioResourceID());
                mMediaPlayer.start();
            }
        });
    }
}
