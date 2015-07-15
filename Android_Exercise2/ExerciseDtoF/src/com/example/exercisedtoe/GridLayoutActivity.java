package com.example.exercisedtoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class GridLayoutActivity extends Activity {
	private String layout[] = { "Relative", "Linear", "List", "Toast" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_layout);

		GridView grid = (GridView) findViewById(R.id.gridView);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, layout);

		grid.setAdapter(adapter);

		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String item = ((TextView) view).getText().toString();
				switch (item) {
				case "Linear":
					changeActivity(LinearActivity.class);
					break;
				case "List":
					changeActivity(ListLayoutActivity.class);
					break;
				case "Relative":
					changeActivity(MainActivity.class);
					break;
				case "Toast":
					Toast.makeText(getApplicationContext(),
							R.string.toast_message2, Toast.LENGTH_SHORT).show();
					break;

				}
			}
		});
	}

	private void changeActivity(Class<?> destClass) {
		Intent i = new Intent(getApplicationContext(), destClass);
		startActivity(i);
	}
}
