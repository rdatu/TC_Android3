package com.example.exercisedtoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 * Purposedly repeated each code to simulate Activity
 * and XML Layout practice.
 */
public class LinearActivity extends Activity {
	private Button mChangeLayoutButton;
	private Button mGridViewButton;
	private Button mListViewButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_layout);

		mChangeLayoutButton = (Button) findViewById(R.id.changeLayoutButton);
		mChangeLayoutButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(i);
			}
		});

	}
}
