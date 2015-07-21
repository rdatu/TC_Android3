package com.cyscorpions.android.rdatu.exercise_day3.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cyscorpions.android.rdatu.exercise_day3.R;

public class HomeActivity extends Activity {
	private Button mMessagingButton, mShowImageButton, mContactButton;
	public static final String EXTRA_IMAGE = "EXTRA_IMAGE";

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

		mContactButton = (Button) findViewById(R.id.contactButton);
		mContactButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						ContactListActivity.class);
				i.putExtra(EXTRA_IMAGE, 0);
				startActivity(i);

			}
		});
	}
}
