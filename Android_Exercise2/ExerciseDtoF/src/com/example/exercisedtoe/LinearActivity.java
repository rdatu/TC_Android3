package com.example.exercisedtoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LinearActivity extends Activity {

	static class ViewHolder {
		Button mChangeLayoutButton, mGridViewButton, mListButton;
		TextView mLabel;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear_layout);

		ViewHolder holder = new ViewHolder();
		holder.mLabel = (TextView) findViewById(R.id.label);
		holder.mLabel.setText(R.string.linear_label);

		holder.mChangeLayoutButton = (Button) findViewById(R.id.changeLayoutButtonLinear);
		holder.mChangeLayoutButton
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(getApplicationContext(),
								MainActivity.class);
						startActivity(i);

					}
				});

		holder.mGridViewButton = (Button) findViewById(R.id.gridviewButtonLinear);
		holder.mGridViewButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						GridLayoutActivity.class);
				startActivity(i);

			}
		});

		holder.mListButton = (Button) findViewById(R.id.listviewButtonLinear);
		holder.mListButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						ListLayoutActivity.class);
				startActivity(i);

			}
		});
	}
}
