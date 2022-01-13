package com.cisco.ccm.jtapi.client;

import java.util.HashMap;
import javax.telephony.events.Ev;

public class CiscoJtapiEventActionFactory {
	
	private Ev event;
	private HashMap<Integer, CiscoJtapiEventActionInterface> eventServiceMap;
	public CiscoJtapiEventActionFactory(Ev event) {
		this.event = event;
		eventServiceMap = new HashMap<Integer, CiscoJtapiEventActionInterface>();
		eventServiceMap.put(111, new ProvInServiceEvActionImpl());
		eventServiceMap.put(113, new ProvOutOfServiceEvActionImpl());
		eventServiceMap.put(114, new ProvShutdownEvActionImpl());
		eventServiceMap.put(1073745923, new CiscoTermInServiceEvActionImpl());
		eventServiceMap.put(1073745924, new CiscoTermOutOfServiceEvActionImpl());
	}
	
	public CiscoJtapiEventActionInterface getEventService() {
		
		CiscoJtapiEventActionInterface eventService = null;
		
		if (eventServiceMap.containsKey(event.getID())) {
			eventService = eventServiceMap.get(event.getID());
			eventService.setEvent(event);
		}
		return eventService;
	}
}
