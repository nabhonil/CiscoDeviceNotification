package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import com.cisco.jtapi.extensions.CiscoTermInServiceEv;

public class CiscoTermInServiceEvActionImpl implements CiscoJtapiEventActionInterface{
	
	private CiscoTermInServiceEv termEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "CiscoTermInServiceEv event - " + termEv.getTerminal() + " " + termEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CiscoTermInServiceEv exception - " + e.getMessage());
		}
	}

	@Override
	public void setEvent(Ev event) {
		// TODO Auto-generated method stub
		this.termEv = (CiscoTermInServiceEv) event;
	}
}
