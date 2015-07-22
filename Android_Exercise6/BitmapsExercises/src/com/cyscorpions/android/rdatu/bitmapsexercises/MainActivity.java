package com.cyscorpions.android.rdatu.bitmapsexercises;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private GridView mGrid;
	private static LruCache<String, Bitmap> mMemoryCache;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
		final int cacheSize = maxMemory / 8;

		// Using LRU memory cache to store cached image can reduce memory leaks
		// than using an incomplete hashmap cache.
		mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
			@Override
			protected int sizeOf(String key, Bitmap bitmap) {
				return bitmap.getByteCount() / 1024;
			}
		};

		int[] allDrawableIDs = getAllResourceIDs(R.drawable.class);

		CustomGrid adapter = new CustomGrid(MainActivity.this, allDrawableIDs,
				this);
		mGrid = (GridView) findViewById(R.id.grid);
		mGrid.setAdapter(adapter);
	}

	private int[] getAllResourceIDs(Class<?> cls)
			throws IllegalArgumentException {
		Field[] IDFields = cls.getFields();

		int[] IDs = new int[IDFields.length];
		try {
			for (int i = 0; i < IDFields.length; i++) {
				IDs[i] = IDFields[i].getInt(null);
			}
		} catch (Exception e) {
			Log.d("R", "something went wrong");
			throw new IllegalArgumentException();

		}
		return IDs;
	}

	public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
		if (getBitmapFromMemoryCache(key) == null) {
			mMemoryCache.put(key, bitmap);
		}
	}

	public Bitmap getBitmapFromMemoryCache(String key) {
		return mMemoryCache.get(key);
	}

	public void loadBitmap(int resId, ImageView imgView) {
		final String imageKey = String.valueOf(resId);

		final Bitmap bitmap = getBitmapFromMemoryCache(imageKey);

		if (bitmap != null) {
			imgView.setImageBitmap(bitmap);
		} else {
			imgView.setImageResource(R.drawable.a);
			BitmapWorkerTask task = new BitmapWorkerTask();
			task.execute(resId);
		}
	}

	class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {

		@Override
		protected Bitmap doInBackground(Integer... params) {
			final Bitmap bitmap = decodeSampleBitmapFromResource(
					getResources(), params[0], 100, 100);
			addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);

			return bitmap;
		}
	}

	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		int inSampleSize = 1;

		final int height = options.outHeight;
		final int width = options.outWidth;

		if (height > reqHeight || width > reqWidth) {
			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	public static Bitmap decodeSampleBitmapFromResource(Resources res,
			int resId, int reqWidth, int reqHeight) {
		final BitmapFactory.Options options = new BitmapFactory.Options();

		options.inJustDecodeBounds = true;

		BitmapFactory.decodeResource(res, resId, options);

		options.inSampleSize = calculateInSampleSize(options, reqWidth,
				reqHeight);

		options.inJustDecodeBounds = false;

		return BitmapFactory.decodeResource(res, resId, options);

	}

}
