package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import com.cisco.jtapi.extensions.CiscoTermOutOfServiceEv;

public class CiscoTermOutOfServiceEvActionImpl implements CiscoJtapiEventActionInterface{

	@Override
	public void action(Ev event) {
		// TODO Auto-generated method stub
		try {
			if ( event instanceof CiscoTermOutOfServiceEv ) {
				CiscoTermOutOfServiceEv termEv = (CiscoTermOutOfServiceEv) event;
				System.out.println( "CiscoTermOutOfServiceEv event - " + termEv.getTerminal() + " " + termEv.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CiscoTermOutOfServiceEv exception - " + e.getMessage());
		}
	}

}
