package org.guetal.eventbus.samples;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		ListenerA listenerA = new ListenerA();
		listenerA.subscribe();
		
		ListenerB listenerB = new ListenerB();
		listenerB.subscribe();
		
		Broadcaster broadcaster = new Broadcaster();
		broadcaster.broadcast();
		
		listenerB.unsubscribe();
		
		broadcaster.broadcast();
		
		listenerA.unsubscribe();
		
		broadcaster.broadcast();
	}

}
