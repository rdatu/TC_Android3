package com.cyscorpions.android.rdatu.exercise_day3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = "ActivityState";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "Activite state: Created");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(getApplicationContext(), R.string.toast_message_start,
				Toast.LENGTH_LONG).show();
		Log.d(TAG, "Activity state: Started");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(getApplicationContext(), R.string.toast_message_resume,
				Toast.LENGTH_LONG).show();
		Log.d(TAG, "Activity state: Resumed");
	}

	@Override
	protected void onPause() {
		Toast.makeText(getApplicationContext(), R.string.toast_message_pause,
				Toast.LENGTH_LONG).show();
		Log.d(TAG, "Activity state: Paused");
		super.onPause();

	}

	@Override
	protected void onStop() {
		Toast.makeText(getApplicationContext(), R.string.toast_message_stop,
				Toast.LENGTH_LONG).show();
		Log.d(TAG, "Activity state: Stop");
		super.onStop();

	}

	@Override
	protected void onDestroy() {
		Toast.makeText(getApplicationContext(), R.string.toast_message_destroy,
				Toast.LENGTH_LONG).show();
		Log.d(TAG, "Activity state: Destroyed");
		super.onDestroy();

	}

}
