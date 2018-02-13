package com.org.google.event.testcase;


import static org.junit.Assert.*;

import org.junit.Test;

import com.org.google.event.events.SimpleEvent;
import com.org.google.event.events.SubEvent;
import com.org.google.event.test.api.EventHandler;
import com.org.google.event.test.impl.InterviewEventHandler;

public class DefaultEventHandler {

	private EventHandler eventHandler = new InterviewEventHandler();
	
	@Test
	public void testPublishNullEvent(){
		eventHandler.publishEvent(null);
	}
	
	@Test
	public void testRegisterAndPublishEvent(){
		MockEventListener listener = new MockEventListener(new Class[] {SimpleEvent.class,SubEvent.class});
		eventHandler.registerListener("key1", listener);
		eventHandler.publishEvent(new SimpleEvent(this));
		assertTrue(listener.isCalled());
	}
	
	@Test
	public void testListenerWithoutMatchingClass(){
		MockEventListener listener = new MockEventListener(new Class[]{SubEvent.class});
		eventHandler.registerListener("key1", listener);
		eventHandler.publishEvent(new SimpleEvent(this));
		assertFalse(listener.isCalled());
	}
	
	
	@Test
	public void testUnregisterListener(){
		MockEventListener listener1 = new MockEventListener(new Class[]{SimpleEvent.class});
		MockEventListener listener2 = new MockEventListener(new Class[]{SimpleEvent.class});
		
		eventHandler.registerListener("key1", listener1);
		eventHandler.registerListener("key2", listener2);
		eventHandler.unregisterListener("key1");
		eventHandler.publishEvent(new SimpleEvent(this));
		assertFalse(listener1.isCalled());
		assertTrue(listener2.isCalled());
	}
	
	@Test
	public void testRemoveNonExistentListener(){
		InterviewEventHandler  eh = (InterviewEventHandler)eventHandler;
		assertEquals(0,eh.getListeners().size());
		eh.registerListener("key1", new MockEventListener(new Class[]{SimpleEvent.class}));
		assertEquals(1,eh.getListeners().size());
		eh.unregisterListener("key2");
		assertEquals(1,eh.getListeners().size());
		eh.unregisterListener("key1");
		assertEquals(0,eh.getListeners().size());
	}
	
	@Test
	public void testDuplicateKeys(){
		MockEventListener listener1 = new MockEventListener(new Class[]{SimpleEvent.class});
		MockEventListener listener2 = new MockEventListener(new Class[]{SimpleEvent.class});
		
		eventHandler.registerListener("key1", listener1);
		eventHandler.registerListener("key1", listener2);
		eventHandler.publishEvent(new SimpleEvent(this));
		assertFalse(listener1.isCalled());
		assertTrue(listener2.isCalled());
		
		listener1.reset();
		listener2.reset();
		eventHandler.unregisterListener("key1");
		eventHandler.publishEvent(new SimpleEvent(this));
		assertFalse(listener1.isCalled());
		assertFalse(listener2.isCalled());
	}
	
	@Test
	public void testvalidateKeyWithNullListener(){
		try{
		eventHandler.registerListener("key1", null);
		fail("Illegal excpetion expected");
		}catch(IllegalArgumentException e){
			
		}
	}
	
	@Test
	public void testEmptyClasses(){
		MockEventListener listener1 = new MockEventListener(new Class[]{});
		eventHandler.registerListener("key1", listener1);
		eventHandler.publishEvent(new SimpleEvent(this));
		assertTrue(listener1.isCalled());

	}
}
