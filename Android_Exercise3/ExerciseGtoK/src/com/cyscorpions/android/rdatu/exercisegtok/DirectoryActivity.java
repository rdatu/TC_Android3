package com.cyscorpions.android.rdatu.exercisegtok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DirectoryActivity extends FragmentActivity implements
		DatePickerFragment.OnCompleteListener {

	private Button mHelloWorld, mRunAppList, mSetDate;
	private TextView mHelloWorldText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_directory);

		mHelloWorldText = (TextView) findViewById(R.id.helloWorldText);
		registerForContextMenu(mHelloWorldText);
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

		mSetDate = (Button) findViewById(R.id.setDateButton);
		mSetDate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment newFrag = new DatePickerFragment();

				newFrag.show(getSupportFragmentManager(), "datePicker");
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.logout:
			logout();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case (R.id.resetText):
			mHelloWorldText.setText("");
			return true;
		default:
			return super.onContextItemSelected(item);
		}

	}

	private void logout() {
		Intent i = new Intent();
		setResult(LoginActivity.RESULT_LOGOUT, i);
		finish();
	}

	@Override
	public void onComplete(String date) {
		// TODO Auto-generated method stub
		mSetDate.setText(date);
	}

}
