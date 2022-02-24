package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import com.cisco.jtapi.extensions.CiscoRTPInputStartedEv;

public class CiscoRTPInputStartedEvActionImpl implements CiscoJtapiEventActionInterface{
	
	private CiscoRTPInputStartedEv termEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "CiscoRTPInputStartedEv event - " + termEv.getTerminal() + " " + termEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CiscoRTPInputStartedEv exception - " + e.getMessage());
		}
	}

	@Override
	public void setEvent(Ev event) {
		// TODO Auto-generated method stub
		this.termEv = (CiscoRTPInputStartedEv) event;
	}

}
