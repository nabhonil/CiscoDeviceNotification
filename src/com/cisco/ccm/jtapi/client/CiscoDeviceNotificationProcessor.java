package com.cisco.ccm.jtapi.client;

import java.util.concurrent.LinkedBlockingQueue;
import javax.telephony.events.Ev;
import com.cisco.cti.util.Condition;

public class CiscoDeviceNotificationProcessor implements Runnable {
	
	private LinkedBlockingQueue<CiscoJtapiEventBean> eventsQueue;
	private boolean stopProcessor;
	private Condition condition;
	
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
			CiscoJtapiEventActionFactory eventFactory = new CiscoJtapiEventActionFactory();
			while (! isStopProcessor()) {
				CiscoJtapiEventBean eventBean = this.eventsQueue.take();
				int eventType = eventBean.getEventType();
				Ev event = eventBean.getEvent();
				System.out.println("Processing Event: " + event.getID() + " - " + event.toString());
				eventFactory.setEvent(event);
				if (eventFactory.eventExistInFactory()) {
					switch (eventType) {
						case (CiscoJtapiEventBean.EVENT_PROVIDER): {
							//Handle the Provider events
							eventFactory.getEventService().action();
							this.condition.set();
						}
						case (CiscoJtapiEventBean.EVENT_TERMINAL): {
							//Handle the Terminal events
							eventFactory.getEventService().action();
						}
						default: {
							//Other events just ignore for the time being.
						}
					}	
				} else {
					System.out.println("Cannot Process Event: " + event.getID() + " - " + event.toString());
				}
			}
			eventFactory = null;
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
