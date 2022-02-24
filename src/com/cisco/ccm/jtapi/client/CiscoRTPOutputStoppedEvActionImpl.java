package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import com.cisco.jtapi.extensions.CiscoRTPOutputStoppedEv;

public class CiscoRTPOutputStoppedEvActionImpl implements CiscoJtapiEventActionInterface{
	
	private CiscoRTPOutputStoppedEv termEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "CiscoRTPOutputStoppedEv event - " + termEv.getTerminal() + " " + termEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CiscoRTPOutputStoppedEv exception - " + e.getMessage());
		}
	}

	@Override
	public void setEvent(Ev event) {
		// TODO Auto-generated method stub
		this.termEv = (CiscoRTPOutputStoppedEv) event;
	}

}
