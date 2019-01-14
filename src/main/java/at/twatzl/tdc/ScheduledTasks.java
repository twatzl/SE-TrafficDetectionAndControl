package at.twatzl.tdc;

import at.twatzl.tdc.Model.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	TDCData data;

	/**
	 * Update all devices every 5000ms.
	 */
	@Scheduled(fixedRate = 5000)
	public void updateDevices() {
		log.info("Running device update");
		for (Device d : data.getDeviceList()) {
			d.update();
		}
		log.info("devices updated");
	}
}