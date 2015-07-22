package com.cyscorpions.android.rdatu.exercise_day3.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.cyscorpions.android.rdatu.exercise_day3.R;
import com.cyscorpions.android.rdatu.exercise_day3.controller.DecodeBitmap;

public class ContactActivity extends Activity {

	private EditText mContactName, mContactNumber;
	private ImageView mContactImage;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);

		Intent i = getIntent();

		int id = Integer
				.decode(i.getStringExtra(ContactListActivity.TAG_IMAGE));

		mContactImage = (ImageView) findViewById(R.id.contactImage);
		mContactImage.setImageBitmap(DecodeBitmap
				.decodeSampleBitmapFromResource(getResources(), id, 256, 256));

		mContactName = (EditText) findViewById(R.id.contactName);
		mContactName.setText(i.getStringExtra(ContactListActivity.TAG_NAME));

		mContactNumber = (EditText) findViewById(R.id.contactNumber);
		mContactNumber
				.setText(i.getStringExtra(ContactListActivity.TAG_NUMBER));
	}
}
