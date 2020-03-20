package com.example.hindi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ListView listView = findViewById(R.id.list);

        final ArrayList<Words> wordsList = new ArrayList<Words>();

        //Can also be:
        // Words w = new Words("Ek","One");     //using constructor overloading to use the 2-argument constructor
        //wordsList.add(w);

        wordsList.add(new Words("Ek","One",R.raw.phrase_what_is_your_name));
        wordsList.add(new Words("Do","Two",R.raw.phrase_my_name_is));
        wordsList.add(new Words("Teen","Three",R.raw.phrase_how_are_you_feeling));
        wordsList.add(new Words("Char","Four",R.raw.phrase_im_feeling_good));
        wordsList.add(new Words("Paanch","Five",R.raw.phrase_lets_go));
        wordsList.add(new Words("Chheh","Six",R.raw.phrase_im_coming));
        wordsList.add(new Words("Saat","Seven",R.raw.phrase_are_you_coming));
        wordsList.add(new Words("Aath","Eight",R.raw.phrase_yes_im_coming));
        wordsList.add(new Words("Nau","Nine",R.raw.phrase_come_here));
        wordsList.add(new Words("Dus","Ten",R.raw.phrase_where_are_you_going));


        WordsAdapter adapter = new WordsAdapter(this, wordsList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Words my_word = wordsList.get(position); //get the object at specific position from ListView
                MediaPlayer mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, my_word.getAudioResourceID());
                mMediaPlayer.start();
            }
        });
    }
}
