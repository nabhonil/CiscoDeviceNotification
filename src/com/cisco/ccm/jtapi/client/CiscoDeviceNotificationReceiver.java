package com.cisco.ccm.jtapi.client;

import javax.telephony.Address;
import javax.telephony.JtapiPeer;
import javax.telephony.JtapiPeerFactory;
import javax.telephony.Provider;
import javax.telephony.ProviderObserver;
import javax.telephony.Terminal;
import javax.telephony.events.ProvEv;
import javax.telephony.events.TermEv;
import com.cisco.cti.util.Condition;
import com.cisco.jtapi.extensions.CiscoTerminalObserver;
import java.util.concurrent.LinkedBlockingQueue;

public class CiscoDeviceNotificationReceiver implements ProviderObserver, CiscoTerminalObserver {
	
	private static LinkedBlockingQueue<CiscoJtapiEventBean> eventsQueue;
	private static Thread cdnp;
	private static CiscoDeviceNotificationReceiver cdnr = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Condition conditionInService = new Condition ();
		Provider provider;
		Terminal terminals[];
		cdnr = new CiscoDeviceNotificationReceiver();
		try {
			eventsQueue = new LinkedBlockingQueue<CiscoJtapiEventBean>();
			cdnp = new Thread (new CiscoDeviceNotificationProcessor(eventsQueue, false, conditionInService));
			cdnp.start();
			
			JtapiPeer peer = JtapiPeerFactory.getJtapiPeer ( null );
			System.out.println ("Got peer "+ peer);
			provider = peer.getProvider("nasinha-lnx;login=ccucadmin;passwd=c1sc0!@#");
			System.out.println ("Got provider "+ provider);
			
			provider.addObserver(cdnr);
			conditionInService.waitTrue ();
			
			System.out.println ("Provider is now in service");
			Address[] addresses = provider.getAddresses();
			System.out.println ("Found "+ addresses.length +" addresses");
			for ( int i = 0; i < addresses.length; i++)  {
				terminals = addresses[i].getTerminals();
				for ( int j = 0; j < terminals.length; j++ ) {
					System.out.println("Terminal: "+ terminals[j]);
					terminals[j].addObserver(cdnr);
				}
				System.out.println("Address: " + addresses[i]);
			}
			while (true) {
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception - main: " + e.getMessage());
		}
	}

	@Override
	public void providerChangedEvent(ProvEv[] eventList) {
		// TODO Auto-generated method stub
		try {
			if ( eventList != null ) {
				for ( int i = 0; i < eventList.length; i++ ) 
					eventsQueue.put(new CiscoJtapiEventBean(CiscoJtapiEventBean.EVENT_PROVIDER, eventList[i]));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception - providerChangedEvent: " + e.getMessage());
		}
	}

	@Override
	public void terminalChangedEvent(TermEv[] eventList) {
		// TODO Auto-generated method stub
		try {
			if ( eventList != null ) {
				for ( int i = 0; i < eventList.length; i++ ) 
					eventsQueue.put(new CiscoJtapiEventBean(CiscoJtapiEventBean.EVENT_TERMINAL, eventList[i]));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception - terminalChangedEvent: " + e.getMessage());
		}
	}
}
