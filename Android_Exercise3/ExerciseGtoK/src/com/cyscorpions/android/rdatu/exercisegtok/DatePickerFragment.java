package com.cyscorpions.android.rdatu.exercisegtok;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatePickerFragment extends DialogFragment implements
		DatePickerDialog.OnDateSetListener {

	public static interface OnCompleteListener {
		public abstract void onComplete(String date);
	}

	private OnCompleteListener mListener;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			this.mListener = (OnCompleteListener) activity;
			Log.d("Exercise", "" + (this.mListener == null));
		} catch (final ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnCompleteListener");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_WEEK_IN_MONTH);

		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayOfMonth) {
		// TODO Auto-generated method stub
		String date = monthOfYear + "/" + dayOfMonth + "/" + year;
		Toast.makeText(getActivity(), date, Toast.LENGTH_LONG).show();
		Log.d("Exercise", date);
		this.mListener.onComplete(date);

	}
}
