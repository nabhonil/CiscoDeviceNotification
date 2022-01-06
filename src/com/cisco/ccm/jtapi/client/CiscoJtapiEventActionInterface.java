package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;

public interface CiscoJtapiEventActionInterface {
	
	public void action();
	public void setEvent(Ev event);

}
