
package com.example.karim.miwokapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn1 = (Button) findViewById(R.id.num);
		btn1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(MainActivity.this,NumbersActivity.class);
				startActivity(intent);
			}
		});
		Button btn2 = (Button) findViewById(R.id.family);
		btn2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(MainActivity.this,FamilyActivity.class);
				startActivity(intent);
			}
		});
		Button btn3 = (Button) findViewById(R.id.color);
		btn3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(MainActivity.this,ColorsActivity.class);
				startActivity(intent);
			}
		});
		Button btn4 = (Button) findViewById(R.id.phrase);
		btn4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view)
			{
				Intent intent = new Intent(MainActivity.this,PhrasesActivity.class);
				startActivity(intent);
			}
		});
	}
}
