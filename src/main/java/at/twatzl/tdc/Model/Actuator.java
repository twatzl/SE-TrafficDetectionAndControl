package at.twatzl.tdc.Model;

import java.util.Date;

public abstract class Actuator extends Device {

	public Actuator() {
	}

	public Actuator(Date lastInspectionDate, int deviceId, Location location, DeviceStatus status, String displayName) {
		super(lastInspectionDate, deviceId, location, status, displayName);
	}

	public abstract String[] operations();

	public abstract String doOperation(String operation);

}
