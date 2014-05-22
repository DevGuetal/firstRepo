package org.guetal.eventbus.samples;

import org.guetal.eventbus.EventBus;

public class ListenerA {

	public void subscribe() {
		EventBus.getInstance().subscribeEvent(Broadcaster.event, "onBroadcast", this);
	}

	public void onBroadcast() {
		System.out.println("A");
	}
	
	public void unsubscribe() {
		EventBus.getInstance().unsubscribeEvent(Broadcaster.event, this);
	}
}
