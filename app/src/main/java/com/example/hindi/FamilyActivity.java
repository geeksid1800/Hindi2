package com.example.hindi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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
        wordsList.add(new Words("father", "әpә", R.drawable.family_father,R.raw.family_father));
        wordsList.add(new Words("mother", "әṭa", R.drawable.family_mother,R.raw.family_mother));
        wordsList.add(new Words("son", "angsi", R.drawable.family_son,R.raw.family_son));
        wordsList.add(new Words("daughter", "tune", R.drawable.family_daughter,R.raw.family_daughter));
        wordsList.add(new Words("older brother", "taachi", R.drawable.family_older_brother,R.raw.family_older_brother));
        wordsList.add(new Words("younger brother", "chalitti", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        wordsList.add(new Words("older sister", "teṭe", R.drawable.family_older_sister,R.raw.family_older_sister));
        wordsList.add(new Words("younger sister", "kolliti", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        wordsList.add(new Words("grandmother ", "ama", R.drawable.family_grandmother,R.raw.family_grandmother));
        wordsList.add(new Words("grandfather", "paapa", R.drawable.family_grandfather,R.raw.family_grandfather));

        WordsAdapter adapter = new WordsAdapter(this, wordsList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words my_word = wordsList.get(position); //get the object at specific position from ListView
                MediaPlayer mMediaPlayer = MediaPlayer.create(FamilyActivity.this, my_word.getAudioResourceID());
                mMediaPlayer.start();
            }
        });
    }
}