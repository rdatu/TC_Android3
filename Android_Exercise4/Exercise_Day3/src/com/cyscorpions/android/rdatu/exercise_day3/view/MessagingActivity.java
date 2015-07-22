package com.cyscorpions.android.rdatu.exercise_day3.view;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cyscorpions.android.rdatu.exercise_day3.R;

public class MessagingActivity extends FragmentActivity implements
		ConfirmDialog.ConfirmDialogListener {

	private static final String TAG = "ActivityState";
	private Button mSendButton;

	private EditText mContactText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messaging);
		Log.d(TAG, "Activity state: Created");

		mContactText = (EditText) findViewById(R.id.contactInput);

		mSendButton = (Button) findViewById(R.id.sendButton);
		mSendButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mContactText.getText().toString().equals(null)
						|| mContactText.getText().toString().equals("")) {
					Toast.makeText(getApplicationContext(),
							R.string.send_warning, Toast.LENGTH_SHORT).show();
					return;
				}

				String msg = String.format(
						getResources().getString(R.string.dialog_message),
						mContactText.getText().toString());

				DialogFragment dialog = new ConfirmDialog(msg);
				dialog.show(getSupportFragmentManager(), "ConfirmDialog");
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();

		Log.d(TAG, "Activity state: Started");
	}

	@Override
	protected void onResume() {
		super.onResume();

		Log.d(TAG, "Activity state: Resumed");
	}

	@Override
	protected void onPause() {

		Log.d(TAG, "Activity state: Paused");
		super.onPause();

	}

	@Override
	protected void onStop() {

		Log.d(TAG, "Activity state: Stop");
		super.onStop();

	}

	@Override
	protected void onDestroy() {

		Log.d(TAG, "Activity state: Destroyed");
		super.onDestroy();

	}

	@Override
	public void onDialogPositiveClick(DialogFragment dialog) {
		Toast.makeText(getApplicationContext(), R.string.toast_sent,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDialogNegativeClick(DialogFragment dialog) {
		Toast.makeText(getApplicationContext(), R.string.toast_cancelled,
				Toast.LENGTH_SHORT).show();

	}

}
