package com.cisco.ccm.jtapi.client;

import javax.telephony.events.Ev;
import javax.telephony.events.ProvShutdownEv;

public class ProvShutdownEvActionImpl implements CiscoJtapiEventActionInterface{

	@Override
	public void action(Ev event) {
		// TODO Auto-generated method stub
		try {
			if (event instanceof ProvShutdownEv) {
				ProvShutdownEv provEv = (ProvShutdownEv) event;
				System.out.println( "ProvShutdownEv event - " + provEv.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ProvShutdownEv exception - " + e.getMessage());
		}
	}

}
