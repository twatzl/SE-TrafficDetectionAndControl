package at.twatzl.tdc.Model;

import java.util.Date;

public abstract class Device {

	public Date lastInspectionDate;
	public int deviceId;
	public Location location;
	public DeviceStatus status;
	public String displayName;

	public Device() {}

	public Device(Date lastInspectionDate, int deviceId, Location location, DeviceStatus status, String displayName) {
		this.lastInspectionDate = lastInspectionDate;
		this.deviceId = deviceId;
		this.location = location;
		this.status = status;
		this.displayName = displayName;
	}

	/**
	 * Update is called regularly to allow to update device status and values.
	 */
	public abstract void update();

	/**
	 * Establish a connection to the hardware device.
	 */
	public abstract void connect();

	/**
	 * Send a shutdown signal to the device.
	 */
	public abstract void shutdown();
}
