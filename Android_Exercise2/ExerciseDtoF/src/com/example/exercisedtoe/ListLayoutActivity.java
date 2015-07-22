package com.example.exercisedtoe;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListLayoutActivity extends ListActivity {
	private String[] ListItems = { "Linear", "Relative", "GridView", "Toast" };

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_layout,
				ListItems));

		ListView list = getListView();
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String item = ((TextView) view).getText().toString();
				switch (item) {
				case "Linear":
					changeActivity(LinearActivity.class);
					break;
				case "Relative":
					changeActivity(MainActivity.class);
					break;
				case "GridView":
					changeActivity(GridLayoutActivity.class);
					break;
				case "Toast":
					Toast.makeText(getApplicationContext(),
							R.string.toast_message, Toast.LENGTH_SHORT).show();
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
