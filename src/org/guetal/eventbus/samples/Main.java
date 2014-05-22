package org.guetal.eventbus.samples;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		new ListenerA().subscribe();
		new ListenerB().subscribe();
		
		new Broadcaster().broadcast();
	}

}
