package com.org.google.event.test.api;

public interface EventHandler {
	
	void publishEvent(InterviewEvent event);
	
	void registerListener(String listenerKey,EventListener listener);
	void unregisterListener(String listenerKey);

}
