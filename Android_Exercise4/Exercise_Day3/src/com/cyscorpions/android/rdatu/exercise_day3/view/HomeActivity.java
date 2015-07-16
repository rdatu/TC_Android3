package com.cyscorpions.android.rdatu.exercise_day3.view;

import com.cyscorpions.android.rdatu.exercise_day3.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {
	private Button mMessagingButton, mShowImageButton;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		mMessagingButton = (Button) findViewById(R.id.homeMessaging);
		mMessagingButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						MessagingActivity.class);
				startActivity(i);
			}
		});

		mShowImageButton = (Button) findViewById(R.id.homeShowImage);
		mShowImageButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						ImageActivity.class);
				startActivity(i);
			}
		});
	}
}
