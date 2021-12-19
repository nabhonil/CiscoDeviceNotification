package com.cisco.ccm.jtapi.client;

import java.util.concurrent.LinkedBlockingQueue;
import javax.telephony.events.Ev;
import com.cisco.cti.util.Condition;

public class CiscoDeviceNotificationProcessor implements Runnable {
	
	private LinkedBlockingQueue<CiscoJtapiEventBean> eventsQueue;
	private boolean stopProcessor;
	private Condition condition;
	private ProvInServiceEvActionImpl providerInService = new ProvInServiceEvActionImpl();
	private ProvOutOfServiceEvActionImpl providerOutService = new ProvOutOfServiceEvActionImpl();
	private ProvShutdownEvActionImpl providerShutdownService = new ProvShutdownEvActionImpl();
	private CiscoTermInServiceEvActionImpl terminalInService = new CiscoTermInServiceEvActionImpl();
	private CiscoTermOutOfServiceEvActionImpl terminalOutService = new CiscoTermOutOfServiceEvActionImpl();
	
	public CiscoDeviceNotificationProcessor (LinkedBlockingQueue<CiscoJtapiEventBean> evQueue, 
											boolean stopProcessor,
											Condition conditionInService) {
		this.eventsQueue = evQueue;
		this.stopProcessor = stopProcessor;
		this.condition = conditionInService;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try { 
			while (! isStopProcessor()) {
				CiscoJtapiEventBean eventBean = this.eventsQueue.take();
				int eventType = eventBean.getEventType();
				Ev event = eventBean.getEvent();
				switch (eventType) {
					case (CiscoJtapiEventBean.EVENT_PROVIDER): {
						//Handle the Provider events
						providerInService.action(event);
						providerOutService.action(event);
						providerShutdownService.action(event);
						this.condition.set();
					}
					case (CiscoJtapiEventBean.EVENT_TERMINAL): {
						//Handle the Terminal events
						terminalInService.action(event);
						terminalOutService.action(event);
					}
					default: {
						//Other events just ignore for the time being.
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception - CiscoDeviceNotificationProcessor: " + e.getMessage());
		}
	}

	public boolean isStopProcessor() {
		return stopProcessor;
	}

	public void setStopProcessor(boolean stopProcessor) {
		this.stopProcessor = stopProcessor;
	}
}
