package com.example.karim.miwokapp;

import android.view.View;
import android.widget.Toast;

/**
 * Created by KARIM on 8/8/2017.
 */

public class NumbersClickListener implements View.OnClickListener {
	@Override
	public void onClick(View view)
	{
		Toast.makeText(view.getContext(),"Open the list of numbers",Toast.LENGTH_SHORT).show();
	}
}
