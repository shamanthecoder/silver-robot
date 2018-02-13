package com.org.google.event.events;

import com.org.google.event.test.api.InterviewEvent;

public class SimpleEvent implements InterviewEvent {

	private Object  source;
	public SimpleEvent(Object source){
		this.source = source;
	}
	@Override
	public Object getSource() {
		return source;
	}
	

}
