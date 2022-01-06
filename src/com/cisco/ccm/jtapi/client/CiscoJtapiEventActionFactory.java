package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import javax.telephony.events.ProvInServiceEv;
import javax.telephony.events.ProvOutOfServiceEv;
import javax.telephony.events.ProvShutdownEv;
import com.cisco.jtapi.extensions.CiscoTermInServiceEv;
import com.cisco.jtapi.extensions.CiscoTermOutOfServiceEv;

public class CiscoJtapiEventActionFactory {
	
	private Ev event;
	public CiscoJtapiEventActionFactory(Ev event) {
		this.event = event;
	}
	
	public CiscoJtapiEventActionInterface getEventService() {
		
		CiscoJtapiEventActionInterface eventService = null;
		
		if (event instanceof ProvInServiceEv) {
			eventService = new ProvInServiceEvActionImpl();
		} else if (event instanceof ProvOutOfServiceEv) {
			eventService = new ProvOutOfServiceEvActionImpl();
		} else if (event instanceof ProvShutdownEv) {
			eventService = new ProvShutdownEvActionImpl();
		} else if (event instanceof CiscoTermInServiceEv) {
			eventService = new CiscoTermInServiceEvActionImpl();
		} else if (event instanceof CiscoTermOutOfServiceEv) {
			eventService = new CiscoTermOutOfServiceEvActionImpl();
		}
		
		eventService.setEvent(event);
		return eventService;
	}
}
