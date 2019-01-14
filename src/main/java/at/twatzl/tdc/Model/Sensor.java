package at.twatzl.tdc.Model;

import java.util.Date;
import java.util.List;

public abstract class Sensor extends Device {

	public Sensor() {
	}

	public Sensor(Date lastInspectionDate, int deviceId, Location location, DeviceStatus status, String displayName) {
		super(lastInspectionDate, deviceId, location, status, displayName);
	}

	public abstract List<SensorData> getSensorData();

}
