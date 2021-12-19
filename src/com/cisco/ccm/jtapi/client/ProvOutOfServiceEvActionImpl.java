package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import javax.telephony.events.ProvOutOfServiceEv;

public class ProvOutOfServiceEvActionImpl implements CiscoJtapiEventActionInterface {

	@Override
	public void action(Ev event) {
		// TODO Auto-generated method stub
		try {
			if (event instanceof ProvOutOfServiceEv) {
				ProvOutOfServiceEv provEv = (ProvOutOfServiceEv) event;
				System.out.println( "ProvOutOfServiceEv event - " + provEv.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ProvOutOfServiceEv exception - " + e.getMessage());
		}
	}
	
}
