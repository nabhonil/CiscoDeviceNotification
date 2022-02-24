package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import com.cisco.jtapi.extensions.CiscoRTPOutputStartedEv;

public class CiscoRTPOutputStartedEvActionImpl implements CiscoJtapiEventActionInterface{
	
	private CiscoRTPOutputStartedEv termEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "CiscoRTPOutputStartedEv event - " + termEv.getTerminal() + " " + termEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CiscoRTPOutputStartedEv exception - " + e.getMessage());
		}
	}

	@Override
	public void setEvent(Ev event) {
		// TODO Auto-generated method stub
		this.termEv = (CiscoRTPOutputStartedEv) event;
	}

}
