package at.twatzl.tdc.Model;

import java.util.Date;

public abstract class Actuator extends Device {

	public Actuator() {
	}

	public Actuator(Date lastInspectionDate, int deviceId, Location location, DeviceStatus status, String displayName) {
		super(lastInspectionDate, deviceId, location, status, displayName);
	}

	/**
	 * Get all allowed operations for this particular device
	 * @return
	 */
	public abstract String[] operations();

	/**
	 * Execute a given operation on the device.
	 * @param operation
	 * @return
	 */
	public abstract String doOperation(String operation);

}
