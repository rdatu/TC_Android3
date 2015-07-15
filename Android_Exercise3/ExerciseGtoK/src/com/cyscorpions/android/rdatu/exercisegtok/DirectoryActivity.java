package com.cyscorpions.android.rdatu.exercisegtok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DirectoryActivity extends Activity {

	private Button mHelloWorld, mRunAppList, mBrokenAlarmClock;
	private TextView mHelloWorldText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_directory);

		mHelloWorldText = (TextView) findViewById(R.id.helloWorldText);
		mHelloWorld = (Button) findViewById(R.id.helloWorldButton);
		mHelloWorld.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mHelloWorldText.setText(R.string.hello_world);
			}
		});

		mRunAppList = (Button) findViewById(R.id.runAppListButton);
		mRunAppList.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						AppListActivity.class);
				i.putExtra(
						LoginActivity.EXTRA_LOGIN_SUCCESS,
						getIntent().getBooleanExtra(
								LoginActivity.EXTRA_LOGIN_SUCCESS, false));
				i.putExtra(LoginActivity.EXTRA_NAME, getIntent()
						.getStringExtra(LoginActivity.EXTRA_NAME));
				startActivity(i);
			}
		});

		mBrokenAlarmClock = (Button) findViewById(R.id.brokenAlarmClock);
		mBrokenAlarmClock.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Under Construction",
						Toast.LENGTH_LONG).show();
			}
		});

	}
}
