package com.cyscorpions.android.rdatu.exercisegtok;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

public class DatePickerFragment extends DialogFragment implements
		DatePickerDialog.OnDateSetListener {
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
		Toast.makeText(getActivity(),
				"Date Set to " + monthOfYear + "/" + dayOfMonth + "/" + year,
				Toast.LENGTH_LONG).show();
	}
}
