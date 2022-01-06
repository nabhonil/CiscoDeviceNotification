package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import com.cisco.jtapi.extensions.CiscoTermOutOfServiceEv;

public class CiscoTermOutOfServiceEvActionImpl implements CiscoJtapiEventActionInterface{
	
	private CiscoTermOutOfServiceEv termEv;

	@Override
	public void action() {
		// TODO Auto-generated method stub
		try {
			System.out.println( "CiscoTermOutOfServiceEv event - " + termEv.getTerminal() + " " + termEv.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CiscoTermOutOfServiceEv exception - " + e.getMessage());
		}
	}

	@Override
	public void setEvent(Ev event) {
		// TODO Auto-generated method stub
		this.termEv = (CiscoTermOutOfServiceEv) event;
	}

}
