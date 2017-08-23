package com.example.karim.miwokapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
	private MediaPlayer mediaPlayer;

	private AudioManager audioManager;

	private MediaPlayer.OnCompletionListener completelistenr = new MediaPlayer.OnCompletionListener() {
		@Override
		public void onCompletion(MediaPlayer mediaPlayer)
		{
			releaseMediaPlayer();
		}
	};
	private AudioManager.OnAudioFocusChangeListener changeListener = new AudioManager.OnAudioFocusChangeListener()
	{
		@Override
		public void onAudioFocusChange(int focuschange)
		{
			if (focuschange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focuschange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
			{
				mediaPlayer.pause();
				mediaPlayer.seekTo(0);
			}
			else if (focuschange == AudioManager.AUDIOFOCUS_GAIN)
				mediaPlayer.start();
			else if (focuschange == AudioManager.AUDIOFOCUS_LOSS)
				releaseMediaPlayer();
		}
	};

	private void releaseMediaPlayer()
	{
		if (mediaPlayer != null)
		{
			mediaPlayer.release();
			mediaPlayer = null;
			audioManager.abandonAudioFocus(changeListener);
		}
	}
	@Override
	protected void onStop()
	{
		super.onStop();
		releaseMediaPlayer();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.word_list);
		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		final ArrayList<Word> words = new ArrayList<>();
		words.add(new Word("father", "әpә", R.drawable.family_father,R.raw.family_father));
		words.add(new Word("mother", "әṭa", R.drawable.family_mother,R.raw.family_mother));
		words.add(new Word("son", "angsi", R.drawable.family_son,R.raw.family_son));
		words.add(new Word("daughter", "tune", R.drawable.family_daughter,R.raw.family_daughter));
		words.add(new Word("older brother", "taachi", R.drawable.family_older_brother,R.raw.family_older_brother));
		words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,R.raw.family_younger_brother));
		words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,R.raw.family_older_sister));
		words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,R.raw.family_younger_sister));
		words.add(new Word("grandmother ", "ama", R.drawable.family_grandmother,R.raw.family_grandmother));
		words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,R.raw.family_grandfather));
		WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.family);
		ListView listView = (ListView) findViewById(R.id.rootview);
		listView.setAdapter(itemsAdapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?>parent, View view, int position, long id)
			{
				releaseMediaPlayer();
				Word word = words.get(position);
				int res = audioManager.requestAudioFocus(changeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

				if (res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
				{
					mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResID());
					mediaPlayer.start();
					mediaPlayer.setOnCompletionListener(completelistenr);
				}
			}
		});
	}
}
