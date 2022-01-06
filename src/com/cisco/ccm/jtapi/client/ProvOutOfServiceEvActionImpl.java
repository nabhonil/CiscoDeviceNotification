package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import javax.telephony.events.ProvOutOfServiceEv;

public class ProvOutOfServiceEvActionImpl implements CiscoJtapiEventActionInterface {
	
	private ProvOutOfServiceEv provEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "ProvOutOfServiceEv event - " + provEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ProvOutOfServiceEv exception - " + e.getMessage());
		}
	}
	
	@Override
	public void setEvent(Ev event) {
		this.provEv = (ProvOutOfServiceEv) event;
	}
	
}
