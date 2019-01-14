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

	public abstract void update();

	public abstract void connect();

	public abstract void shutdown();

	public Date getLastInspectionDate() {
		return lastInspectionDate;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public Location getLocation() {
		return location;
	}

	public DeviceStatus getStatus() {
		return status;
	}

	public String getDisplayName() {
		return displayName;
	}
}
