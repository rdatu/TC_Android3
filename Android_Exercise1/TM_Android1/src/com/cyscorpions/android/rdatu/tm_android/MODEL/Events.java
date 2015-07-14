package com.cyscorpions.android.rdatu.tm_android.MODEL;

import java.util.Date;
import java.util.UUID;

public class Events {
	private UUID mId;
	private String mEvents;
	private Date mDateTime;
	private String[] mParticipants;

	public Events() {
		mId = UUID.randomUUID();
	}

	public String getEvents() {
		return mEvents;
	}

	public void setEvents(String events) {
		mEvents = events;
	}

	public Date getDateTime() {
		return mDateTime;
	}

	public void setDateTime(Date dateTime) {
		mDateTime = dateTime;
	}

	public String[] getParticipants() {
		return mParticipants;
	}

	public void setParticipants(String[] participants) {
		mParticipants = participants;
	}

	public UUID getId() {
		return mId;
	}

}
