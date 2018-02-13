package com.org.google.event.test.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.logging.Logger;

import com.org.google.event.test.api.EventHandler;
import com.org.google.event.test.api.EventListener;
import com.org.google.event.test.api.InterviewEvent;

public class InterviewEventHandler implements EventHandler {

	Map<String,EventListener> listeners = new ConcurrentHashMap<String,EventListener>();
	Map<Class<InterviewEvent> ,List<EventListener>> listenerClasses = new ConcurrentHashMap<>();
	Set<EventListener> allListeners = new HashSet<>();
	//private static final Logger log  = Logger.getLogger(InterviewEventHandler.class.getName());
	
	@Override
	public void publishEvent(InterviewEvent event) {
		if(event == null){
			System.err.println("Null event fired");
			return;
		}
		
		//process the event
		processEvent(event,getListeners(event.getClass()));
		processEvent(event,allListeners);
		
		
	}
	
	 Collection<EventListener> getListeners(Class<? extends InterviewEvent> event){
		return (Collection<EventListener>) listenerClasses.get(event);
	}
	 
	 void processEvent(InterviewEvent event,Collection<EventListener> listeners){
		 if(listeners == null || listeners.isEmpty())
			 return;
		 
		 for(Iterator<EventListener> it = listeners.iterator();it.hasNext();){
			 EventListener listener = (EventListener)it.next();
			 listener.handleEvent(event);
		 }
	 }

	@Override
	public void registerListener(String listenerKey, EventListener listener) {
		if(listenerKey == null || listenerKey.equals("")){
			throw new IllegalArgumentException("Listenerkey cannot be null or empty");
		}
		if(listener == null)
			throw new IllegalArgumentException("listener cannot be null");
		if(listeners.containsKey(listenerKey))
			unregisterListener(listenerKey);
		
		Class<InterviewEvent> [] classes = listener.getListenersByClass();
		if(classes.length == 0){
			allListeners.add(listener);
		}else{
			for(int i =0 ;i<classes.length;i++){
				addtoListenersList(classes[i],listener);
			}
		}
		listeners.put(listenerKey, listener);
	}

	@Override
	public void unregisterListener(String listenerKey) {
		EventListener listener = listeners.get(listenerKey);
		if(listeners.get(listenerKey) == null)
		return;
		
		for(Iterator<List<EventListener>> it = listenerClasses.values().iterator();it.hasNext();){
			List<EventListener> list = it.next();
			list.remove(listener);
		}
		allListeners.remove(listener);
		listeners.remove(listenerKey);
		
	}
	
	private void addtoListenersList(Class<InterviewEvent> classA, EventListener listener){
		List<EventListener> listeners = listenerClasses.putIfAbsent(classA, new ArrayList<EventListener>());
		if(listeners == null){
			listenerClasses.get(classA).add(listener);
		}else{
			listeners.add(listener);
		}
		
	}
	
	public Map<String,EventListener> getListeners() {
        return listeners;
    }

	
}
