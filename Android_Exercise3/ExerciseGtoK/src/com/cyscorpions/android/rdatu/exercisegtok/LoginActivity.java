package com.cyscorpions.android.rdatu.exercisegtok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class LoginActivity extends Activity {
	public static String TAG = "Exercise";
	public static final String EXTRA_NAME = "LoginName";
	public static final String EXTRA_LOGIN_SUCCESS = "IsSuccess";
	public static final int RESULT_LOGOUT = 221;

	private Button mLoginButton;
	private ToggleButton mShowPassword;
	private EditText mUsernameInput, mPasswordInput;
	private boolean mShowPasswordState = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mUsernameInput = (EditText) findViewById(R.id.inputTextUsername);
		mPasswordInput = (EditText) findViewById(R.id.inputTextPassword);

		mShowPassword = (ToggleButton) findViewById(R.id.toggleShowPassword);
		mShowPassword.setChecked(mShowPasswordState);
		mShowPassword
				.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						mShowPassword.setChecked(isChecked);
						if (isChecked) {
							mPasswordInput
									.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
						} else {
							mPasswordInput
									.setInputType(InputType.TYPE_CLASS_TEXT
											| InputType.TYPE_TEXT_VARIATION_PASSWORD);
							mPasswordInput.setSelection(mPasswordInput
									.getText().length());
						}
					}
				});

		mLoginButton = (Button) findViewById(R.id.buttonLogin);
		mLoginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String username = mUsernameInput.getText().toString();
				String password = mPasswordInput.getText().toString();
				boolean accepted = loginCheck(username, password);
				if (accepted) {
					// TODO: LOGIN
					Intent i = new Intent(getApplicationContext(),
							AppListActivity.class);
					i.putExtra(EXTRA_NAME, username);
					i.putExtra(EXTRA_LOGIN_SUCCESS, accepted);
					startActivityForResult(i, RESULT_LOGOUT);

				} else {
					Toast.makeText(getBaseContext(),
							R.string.toast_invalid_login, Toast.LENGTH_LONG)
							.show();
				}
			}
		});
	}

	private boolean loginCheck(String username, String password) {
		String resUsername, resPassword;
		resUsername = getResources().getString(R.string.coded_username);
		resPassword = getResources().getString(R.string.coded_password);

		return (username.equals(resUsername) && password.equals(resPassword)) ? true
				: false;
	}
}