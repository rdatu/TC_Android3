package com.cyscorpions.android.rdatu.exercisegtok;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.w3c.dom.Text;
import android.R.color;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class AppListActivity extends ListActivity {
	public static final String EXERCISE_ACTION = "com.cyscorpions.exercisegtok.Intent.EXERCISE_ACTION";
	private boolean mIsLoggedIn = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mIsLoggedIn = getIntent().getBooleanExtra(
				LoginActivity.EXTRA_LOGIN_SUCCESS, false);

		if (mIsLoggedIn) {
			Toast.makeText(getApplicationContext(), R.string.toast_valid_login,
					Toast.LENGTH_LONG).show();
		}

		Intent startUpIntent = new Intent(Intent.ACTION_MAIN);
		startUpIntent.addCategory(Intent.CATEGORY_LAUNCHER);

		final PackageManager pm = getApplicationContext().getPackageManager();

		List<ResolveInfo> appListItems = pm.queryIntentActivities(
				startUpIntent, 0);

		Collections.sort(appListItems, new Comparator<ResolveInfo>() {

			@Override
			public int compare(ResolveInfo lhs, ResolveInfo rhs) {
				return String.CASE_INSENSITIVE_ORDER.compare(lhs.loadLabel(pm)
						.toString(), rhs.loadLabel(pm).toString());
			}
		});

		ArrayAdapter<ResolveInfo> adapter = new ArrayAdapter<ResolveInfo>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				appListItems) {
			public View getView(int pos, View view, ViewGroup parent) {
				View v = super.getView(pos, view, parent);
				TextView tv = (TextView) v;
				tv.setTextColor(Color.BLACK);
				ResolveInfo ri = getItem(pos);
				tv.setText(ri.loadLabel(pm));
				return v;
			}
		};

		setListAdapter(adapter);
	}
}
