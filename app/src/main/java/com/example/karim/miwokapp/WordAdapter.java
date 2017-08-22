package com.example.karim.miwokapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 *  Created by KARIM on 8/10/2017.
 *  */


public class WordAdapter extends ArrayAdapter<Word>
{
	private  int colorResId;
	public WordAdapter(Activity context, ArrayList<Word>items,int colorResId)
	{
		super(context,0,items);
		this.colorResId = colorResId;
	}
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
	{
		View listItemView = convertView;
		if(listItemView == null)
		{
			listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
		}
		Word currentWord =  getItem(position);
		TextView txt1 =(TextView) listItemView.findViewById(R.id.miwokText);
		txt1.setText(currentWord.getMiwokTranslation());
		TextView txt2 = (TextView) listItemView.findViewById(R.id.defaultText);
		txt2.setText(currentWord.getDefaultTranslation());
		ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
		if(currentWord.hasImage())
		{
			imageView.setImageResource(currentWord.getImageResID());
			imageView.setVisibility(View.VISIBLE);
		}
		else
			imageView.setVisibility(View.GONE);
		View textContainer = listItemView.findViewById(R.id.text_container);
		int color = ContextCompat.getColor(getContext(),colorResId);
		textContainer.setBackgroundColor(color);
		return  listItemView;
	}
}
