package com.cisco.ccm.jtapi.client;

import java.util.HashMap;
import javax.telephony.events.Ev;
import javax.telephony.events.ProvInServiceEv;
import javax.telephony.events.ProvOutOfServiceEv;
import javax.telephony.events.ProvShutdownEv;
import com.cisco.jtapi.extensions.CiscoTermInServiceEv;
import com.cisco.jtapi.extensions.CiscoTermOutOfServiceEv;
import com.cisco.jtapi.extensions.CiscoRTPInputStartedEv;
import com.cisco.jtapi.extensions.CiscoRTPInputStoppedEv;
import com.cisco.jtapi.extensions.CiscoRTPOutputStartedEv;
import com.cisco.jtapi.extensions.CiscoRTPOutputStoppedEv;

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
		eventServiceMap.put(CiscoRTPOutputStartedEv.ID, new CiscoRTPOutputStartedEvActionImpl());
		eventServiceMap.put(CiscoRTPOutputStoppedEv.ID, new CiscoRTPOutputStoppedEvActionImpl());
		eventServiceMap.put(CiscoRTPInputStartedEv.ID, new CiscoRTPInputStartedEvActionImpl());
		eventServiceMap.put(CiscoRTPInputStoppedEv.ID, new CiscoRTPInputStoppedEvActionImpl());
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
	
	public boolean eventExistInFactory() {
		return eventServiceMap.containsKey(event.getID());
	}
}
