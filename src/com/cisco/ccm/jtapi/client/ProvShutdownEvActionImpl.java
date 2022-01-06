package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import javax.telephony.events.ProvShutdownEv;

public class ProvShutdownEvActionImpl implements CiscoJtapiEventActionInterface{
	
	private ProvShutdownEv provEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "ProvShutdownEv event - " + provEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ProvShutdownEv exception - " + e.getMessage());
		}
	}
	
	@Override
	public void setEvent(Ev event) {
		this.provEv = (ProvShutdownEv) event;
	}

}
