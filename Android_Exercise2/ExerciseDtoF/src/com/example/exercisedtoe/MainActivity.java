package com.example.exercisedtoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button mChangeLayoutButton, mGridViewButton, mListViewButton;
	TextView mLabel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative_layout);

		mLabel = (TextView) findViewById(R.id.label);
		mLabel.setText(R.string.relative_label);

		mChangeLayoutButton = (Button) findViewById(R.id.changeLayoutButton);
		mChangeLayoutButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						LinearActivity.class);
				startActivity(i);
			}
		});

		mGridViewButton = (Button) findViewById(R.id.gridviewButton);
		mGridViewButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						GridLayoutActivity.class);
				startActivity(i);
			}
		});

		mListViewButton = (Button) findViewById(R.id.listviewButton);
		mListViewButton.setOnClickListener(new View.OnClickListener() {

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
