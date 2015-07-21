package com.cyscorpions.android.rdatu.exercise_day3.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.cyscorpions.android.rdatu.exercise_day3.R;

public class ConfirmDialog extends DialogFragment {

	public interface ConfirmDialogListener {
		public void onDialogPositiveClick(DialogFragment dialog);

		public void onDialogNegativeClick(DialogFragment dialog);
	}

	ConfirmDialogListener mListener;
	private String mMessage;

	public ConfirmDialog(String msg) {
		mMessage = msg;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		try {
			mListener = (ConfirmDialogListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ "must implement NoticeDialogInterface");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder.setMessage(mMessage);
		builder.setPositiveButton(R.string.dialog_send,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mListener.onDialogPositiveClick(ConfirmDialog.this);
					}
				});

		builder.setNegativeButton(R.string.dialog_cancel,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mListener.onDialogNegativeClick(ConfirmDialog.this);
					}
				});

		return builder.create();
	}
}
