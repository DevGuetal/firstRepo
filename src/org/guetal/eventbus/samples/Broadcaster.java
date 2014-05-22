package org.guetal.eventbus.samples;

import org.guetal.eventbus.EventBus;


public class Broadcaster {

	public static String event = "broadcast";

	public void broadcast() {
		EventBus.getInstance().broadcastEvent(event);
	}
}
