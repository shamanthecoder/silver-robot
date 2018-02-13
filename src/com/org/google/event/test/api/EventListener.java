package com.org.google.event.test.api;

public interface EventListener {
	
	void handleEvent(InterviewEvent event);
	
	Class[] getListenersByClass();

}
