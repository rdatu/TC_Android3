package com.cyscorpions.android.rdatu.exercise_day3.controller;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.cyscorpions.android.rdatu.exercise_day3.R;
import com.cyscorpions.android.rdatu.exercise_day3.view.ContactListActivity;
import com.cyscorpions.android.rdatu.exercise_day3.view.HomeActivity;
import com.cyscorpions.android.rdatu.exercise_day3.view.ImageActivity;

public class ContactAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<HashMap<String, String>> mData;
	private HashMap<String, String> mResult = new HashMap<String, String>();

	public ContactAdapter(Context context,
			ArrayList<HashMap<String, String>> arrayList) {
		this.mContext = context;
		mData = arrayList;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView mTextViewName;
		ImageView mImageView;

		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View itemView = mInflater.inflate(R.layout.contact_list_item, parent,
				false);

		mResult = mData.get(position);

		mTextViewName = (TextView) itemView.findViewById(R.id.item_name);
		mTextViewName.setText(mResult.get(ContactListActivity.TAG_NAME));
		mImageView = (ImageView) itemView.findViewById(R.id.item_image);
		final int imageRes = Integer.decode(mResult
				.get(ContactListActivity.TAG_IMAGE));

		mImageView.setImageBitmap(DecodeBitmap.decodeSampleBitmapFromResource(
				mContext.getResources(), imageRes, 256, 256));

		mImageView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(mContext, ImageActivity.class);
				i.putExtra(HomeActivity.EXTRA_IMAGE, imageRes);
				mContext.startActivity(i);
			}
		});
		return itemView;
	}

}
