package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import com.cisco.jtapi.extensions.CiscoRTPInputStoppedEv;

public class CiscoRTPInputStoppedEvActionImpl implements CiscoJtapiEventActionInterface{
	
	private CiscoRTPInputStoppedEv termEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "CiscoRTPInputStoppedEv event - " + termEv.getTerminal() + " " + termEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CiscoRTPInputStoppedEv exception - " + e.getMessage());
		}
	}

	@Override
	public void setEvent(Ev event) {
		// TODO Auto-generated method stub
		this.termEv = (CiscoRTPInputStoppedEv) event;
	}

}
