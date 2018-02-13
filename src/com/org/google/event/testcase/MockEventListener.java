package com.org.google.event.testcase;

import com.org.google.event.test.api.EventListener;
import com.org.google.event.test.api.InterviewEvent;

public class MockEventListener implements EventListener{

	private boolean called = false;
	int count=0;
	Class<InterviewEvent>[] classes;
	
	public MockEventListener(Class<InterviewEvent>[] classes){
		this.classes = classes;
	}
	
	public void reset(){
		called = false;
	}
	
	public boolean isCalled(){
		return this.called;
	}
	
	@Override
	public void handleEvent(InterviewEvent event) {
		this.called = true;
		count++;
	}

	@Override
	public Class<? extends InterviewEvent>[] getListenersByClass() {
		return classes;
	}
	

}
