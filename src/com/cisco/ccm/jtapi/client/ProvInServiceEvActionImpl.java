package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import javax.telephony.events.ProvInServiceEv;

public class ProvInServiceEvActionImpl implements CiscoJtapiEventActionInterface {
	
	private ProvInServiceEv provEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "ProvInServiceEv event - " + provEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ProvInServiceEv exception - " + e.getMessage());
		}
	}

	@Override
	public void setEvent(Ev event) {
		// TODO Auto-generated method stub
		this.provEv = (ProvInServiceEv) event; 
	}
}
