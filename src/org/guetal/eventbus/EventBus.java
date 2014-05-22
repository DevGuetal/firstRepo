package org.guetal.eventbus;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class EventBus {
	
	private static EventBus instance = null;
	
	private HashMap<String, HashMap<Object, String>> eventMap = null;
	
	public static EventBus getInstance() {
		if(instance == null) {
			instance = new EventBus();
		}
		return instance;
	}
	
	private EventBus() {
		this.eventMap = new HashMap<String, HashMap<Object,String>>();
	}
	
	public void subscribeEvent(String eventName, String function, Object className) {
		HashMap<Object, String> eventCallbacks = this.eventMap.get(eventName);
		if(eventCallbacks == null) {
			eventCallbacks = new HashMap<Object, String>();
			this.eventMap.put(eventName, eventCallbacks);
		}
		
		if(!(eventCallbacks.containsKey(className) && eventCallbacks.get(className).equals(function))) { 
			eventCallbacks.put(className, function);
		}
	}
	
	public void broadcastEvent(String eventName) {
		HashMap<Object, String> eventCallbacks = this.eventMap.get(eventName);
		
		Set<Object> keys = eventCallbacks.keySet();
		Iterator<Object> it = keys.iterator();
		
		while (it.hasNext()){
			Object objReference = it.next();
			String callback = eventCallbacks.get(objReference);
			try {

				Class<?> c = Class.forName(objReference.getClass().getName());
				Method  method = c.getDeclaredMethod (callback);
				method.invoke (objReference);
			} catch (Exception e) {
				//Log some error here
			}
		}
		
		
	}
	
}
