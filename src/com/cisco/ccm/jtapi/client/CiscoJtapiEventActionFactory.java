package com.cisco.ccm.jtapi.client;

import java.util.HashMap;
import javax.telephony.events.Ev;
import javax.telephony.events.ProvInServiceEv;
import javax.telephony.events.ProvOutOfServiceEv;
import javax.telephony.events.ProvShutdownEv;
import com.cisco.jtapi.extensions.CiscoTermInServiceEv;
import com.cisco.jtapi.extensions.CiscoTermOutOfServiceEv;

public class CiscoJtapiEventActionFactory {
	
	private Ev event;
	private HashMap<Integer, CiscoJtapiEventActionInterface> eventServiceMap;
	public CiscoJtapiEventActionFactory() {
		eventServiceMap = new HashMap<Integer, CiscoJtapiEventActionInterface>();
		eventServiceMap.put(ProvInServiceEv.ID, new ProvInServiceEvActionImpl());
		eventServiceMap.put(ProvOutOfServiceEv.ID, new ProvOutOfServiceEvActionImpl());
		eventServiceMap.put(ProvShutdownEv.ID, new ProvShutdownEvActionImpl());
		eventServiceMap.put(CiscoTermInServiceEv.ID, new CiscoTermInServiceEvActionImpl());
		eventServiceMap.put(CiscoTermOutOfServiceEv.ID, new CiscoTermOutOfServiceEvActionImpl());
	}
	
	public CiscoJtapiEventActionInterface getEventService() {
		
		CiscoJtapiEventActionInterface eventService = null;
		
		if (eventServiceMap.containsKey(event.getID())) {
			eventService = eventServiceMap.get(event.getID());
			eventService.setEvent(event);
		}
		return eventService;
	}

	public Ev getEvent() {
		return event;
	}

	public void setEvent(Ev event) {
		this.event = event;
	}
}
