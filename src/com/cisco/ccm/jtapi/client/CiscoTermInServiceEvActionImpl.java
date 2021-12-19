package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import com.cisco.jtapi.extensions.CiscoTermInServiceEv;

public class CiscoTermInServiceEvActionImpl implements CiscoJtapiEventActionInterface{

	@Override
	public void action(Ev event) {
		// TODO Auto-generated method stub
		try {
			if ( event instanceof CiscoTermInServiceEv ) {
				CiscoTermInServiceEv termEv = (CiscoTermInServiceEv) event;
				System.out.println( "CiscoTermInServiceEv event - " + termEv.getTerminal() + " " + termEv.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CiscoTermInServiceEv exception - " + e.getMessage());
		}
	}
}
