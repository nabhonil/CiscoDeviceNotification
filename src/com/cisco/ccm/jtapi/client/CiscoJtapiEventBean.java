package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;

public class CiscoJtapiEventBean {
	
	public static final int EVENT_PROVIDER = 0;
	public static final int EVENT_TERMINAL = 1;
	
	private int eventType;
	private Ev event;
	
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public Ev getEvent() {
		return this.event;
	}
	public void setEvent(Ev event) {
		this.event = event;
	}
	public CiscoJtapiEventBean(int evType, Ev ev) {
		this.eventType = evType;
		this.event = ev;
	}
}

