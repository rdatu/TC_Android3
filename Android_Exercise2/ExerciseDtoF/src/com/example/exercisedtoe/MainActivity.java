package com.example.exercisedtoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	static class ViewHolder {
		Button mChangeLayoutButton, mGridViewButton, mListViewButton;
		TextView mLabel;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative_layout);

		ViewHolder holder = new ViewHolder();
		holder.mLabel = (TextView) findViewById(R.id.label);
		holder.mLabel.setText(R.string.relative_label);

		holder.mChangeLayoutButton = (Button) findViewById(R.id.changeLayoutButton);
		holder.mChangeLayoutButton
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(getApplicationContext(),
								LinearActivity.class);
						startActivity(i);
					}
				});

		holder.mGridViewButton = (Button) findViewById(R.id.gridviewButton);
		holder.mGridViewButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						GridLayoutActivity.class);
				startActivity(i);
			}
		});

		holder.mListViewButton = (Button) findViewById(R.id.listviewButton);
		holder.mListViewButton.setOnClickListener(new View.OnClickListener() {

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
