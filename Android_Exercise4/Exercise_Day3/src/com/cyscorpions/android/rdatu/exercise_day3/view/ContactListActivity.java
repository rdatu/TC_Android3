package com.cyscorpions.android.rdatu.exercise_day3.view;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cyscorpions.android.rdatu.exercise_day3.R;
import com.cyscorpions.android.rdatu.exercise_day3.controller.ContactAdapter;
import com.cyscorpions.android.rdatu.exercise_day3.controller.ServiceHandler;

public class ContactListActivity extends Activity {
	private static String mURL = "https://api.myjson.com/bins/3oylm";

	public static final String TAG_CONTACTS = "contacts";
	public static final String TAG_NAME = "name";
	public static final String TAG_IMAGE = "image";
	public static final String TAG_NUMBER = "number";

	private ProgressDialog mProgressDialog;
	private ListView mListView;
	private ContactAdapter mContactAdapter;
	private JSONArray mJSONArrayContacts = null;
	private ArrayList<HashMap<String, String>> mContactList;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_list_activity);

		mContactList = new ArrayList<HashMap<String, String>>();

		new GetContacts().execute();
	}

	private class GetContacts extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = new ProgressDialog(ContactListActivity.this);
			mProgressDialog.setTitle("Android JSON Parse Tutorial");
			mProgressDialog.setMessage("Loading...");
			mProgressDialog.setIndeterminate(false);
			mProgressDialog.show();
			Log.d("Response", "Hi Im in PreExecute");
		}

		@Override
		protected Void doInBackground(Void... params) {
			String jsonStr;
			try {
				ServiceHandler sh = new ServiceHandler();
				jsonStr = sh.makeServiceCall(mURL, ServiceHandler.GET);
			} catch (Exception e) {
				Log.d("Response", "Something went wrong");
				return null;
			}

			Log.d("Response", " > " + jsonStr);

			if (jsonStr != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonStr);
					mJSONArrayContacts = jsonObj.getJSONArray(TAG_CONTACTS);
					for (int i = 0; i < mJSONArrayContacts.length(); i++) {
						JSONObject c = mJSONArrayContacts.getJSONObject(i);

						String name = c.getString(TAG_NAME);
						String image = c.getString(TAG_IMAGE);
						String number = c.getString(TAG_NUMBER);

						HashMap<String, String> contact = new HashMap<String, String>();

						contact.put(TAG_NAME, name);
						contact.put(TAG_IMAGE, image);
						contact.put(TAG_NUMBER, number);

						mContactList.add(contact);

					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Log.e("ServiceHandler", "No Data");
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			mListView = (ListView) findViewById(R.id.list);

			mContactAdapter = new ContactAdapter(ContactListActivity.this,
					mContactList);
			mListView.setAdapter(mContactAdapter);

			mProgressDialog.dismiss();

			mListView
					.setOnItemClickListener(new AdapterView.OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {
							HashMap<String, String> result = mContactList
									.get(position);

							Intent i = new Intent(getApplicationContext(),
									ContactActivity.class);
							i.putExtra(TAG_NAME, result.get(TAG_NAME));
							i.putExtra(TAG_NUMBER, result.get(TAG_NUMBER));
							i.putExtra(TAG_IMAGE, result.get(TAG_IMAGE));

							startActivity(i);
						}
					});

		}
	}

}
