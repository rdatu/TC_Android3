package com.cyscorpions.android.rdatu.exercise_day3.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.cyscorpions.android.rdatu.exercise_day3.R;
import com.cyscorpions.android.rdatu.exercise_day3.controller.DecodeBitmap;

public class ImageActivity extends Activity {

	private static ImageView mImageContainer;
	private int mImageId = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.image_activity);
		mImageContainer = (ImageView) findViewById(R.id.imageview);
		Intent i = getIntent();
		mImageId = i.getIntExtra(HomeActivity.EXTRA_IMAGE, 0);
		if (mImageId == 0) {
			changeImage(R.drawable.bioman);
		} else {
			changeImage(mImageId);
		}
	}

	public void changeImage(int id) {
		mImageContainer.setImageBitmap(DecodeBitmap
				.decodeSampleBitmapFromResource(getResources(), id, 256, 256));
	}

}
