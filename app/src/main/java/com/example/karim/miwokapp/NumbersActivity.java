package com.example.karim.miwokapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.word_list);
		ArrayList<Word> words = new ArrayList<>();
		words.add(new Word("one","lutti",R.drawable.number_one));
		words.add(new Word("two","otiiko",R.drawable.number_two));
		words.add(new Word("three","tolookosu",R.drawable.number_three));
		words.add(new Word("four","oyyisa",R.drawable.number_four));
		words.add(new Word("five","massokka",R.drawable.number_five));
		words.add(new Word("six","temmokka",R.drawable.number_six));
		words.add(new Word("seven","kenekaku",R.drawable.number_seven));
		words.add(new Word("eight","kawinta",R.drawable.number_eight));
		words.add(new Word("nine","wo'e",R.drawable.number_nine));
		words.add(new Word("ten","na'aacha",R.drawable.number_ten));
		WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.numbers);
		ListView listView = (ListView) findViewById(R.id.rootview);
		listView.setAdapter(itemsAdapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?>parent,View view,int position,long id)
			{
				MediaPlayer md =  MediaPlayer.create(NumbersActivity.this,R.raw.number_one);
				md.start();
			}
		});
	}
}