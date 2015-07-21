package com.cyscorpions.android.rdatu.bitmapsexercises;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomGrid extends BaseAdapter {

	private Context mContext;
	private final int[] mImages;
	private Bitmap mBitmapImage;
	private MainActivity mMain;

	public CustomGrid(Context c, int images[], Activity activity) {
		mContext = c;
		mImages = images;
		mMain = (MainActivity) activity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mImages.length;
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
		// TODO Auto-generated method stub
		View grid;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			grid = new View(mContext);
			grid = inflater.inflate(R.layout.grid_item, null);

			ImageView imgView = (ImageView) grid.findViewById(R.id.image);
			mBitmapImage = BitmapFactory.decodeResource(
					mContext.getResources(), mImages[position]);

			mMain.addBitmapToMemoryCache(String.valueOf(mImages[position]),
					mBitmapImage);
			mMain.loadBitmap(mImages[position], imgView);

		} else {
			grid = (View) convertView;
		}
		return grid;
	}
}
