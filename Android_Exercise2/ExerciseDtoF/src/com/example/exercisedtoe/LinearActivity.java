package com.example.exercisedtoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LinearActivity extends Activity {

	private Button mChangeLayoutButton, mGridViewButton, mListButton;
	private TextView mLabel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_layout);

		mLabel = (TextView) findViewById(R.id.label);
		mLabel.setText(R.string.linear_label);

		mChangeLayoutButton = (Button) findViewById(R.id.changeLayoutButtonLinear);
		mChangeLayoutButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(i);

			}
		});

		mGridViewButton = (Button) findViewById(R.id.gridviewButtonLinear);
		mGridViewButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						GridLayoutActivity.class);
				startActivity(i);

			}
		});

		mListButton = (Button) findViewById(R.id.listviewButtonLinear);
		mListButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						ListLayoutActivity.class);
				startActivity(i);

			}
		});
	}
}
