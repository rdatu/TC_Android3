package com.cyscorpions.android.rdatu.tm_android.CONTROLLER;

import java.util.ArrayList;

import android.content.Context;

import com.cyscorpions.android.rdatu.tm_android.MODEL.Events;

public class EventPlanner {

	private ArrayList<Events> mEvents;
	private static EventPlanner sEventPlanner;
	private Context mContext;

	private EventPlanner(Context c) {
		mContext = c;
	}

	public static EventPlanner get(Context c) {
		if (sEventPlanner == null)
			sEventPlanner = new EventPlanner(c.getApplicationContext());
		return sEventPlanner;
	}

	public ArrayList<Events> getEvents() {
		return mEvents;
	}

	public void addEvent(Events e) {
		mEvents.add(e);
	}

	public void removeEvent(Events e) {
		mEvents.remove(e);
	}
}
