package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import javax.telephony.events.ProvInServiceEv;

public class ProvInServiceEvActionImpl implements CiscoJtapiEventActionInterface {

	@Override
	public void action(Ev event) {
		// TODO Auto-generated method stub
		try {
			if (event instanceof ProvInServiceEv) {
				ProvInServiceEv provEv = (ProvInServiceEv) event;
				System.out.println( "ProvInServiceEv event - " + provEv.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ProvInServiceEv exception - " + e.getMessage());
		}
	}
}
