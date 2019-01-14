package at.twatzl.tdc.Model.Mock;

import at.twatzl.tdc.Model.DeviceStatus;
import at.twatzl.tdc.Model.Location;
import at.twatzl.tdc.Model.Sensor;
import at.twatzl.tdc.Model.SensorData;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MockSensor extends Sensor {

	private List<SensorData> sensorData;

	public MockSensor(List<SensorData> sensorData) {
		this.sensorData = sensorData;
	}

	public MockSensor(Date lastInspectionDate, int deviceId, Location location, DeviceStatus status, String displayName, List<SensorData> sensorData) {
		super(lastInspectionDate, deviceId, location, status, displayName);
		this.sensorData = sensorData;
	}

	@Override
	@JsonSerialize
	public List<SensorData> getSensorData() {
		return sensorData;
	}

	@Override
	public void update() {

	}

	@Override
	public void connect() {
		this.status = DeviceStatus.Startup;
	}

	@Override
	public void shutdown() {
		this.status = DeviceStatus.Shutdown;
	}
}
