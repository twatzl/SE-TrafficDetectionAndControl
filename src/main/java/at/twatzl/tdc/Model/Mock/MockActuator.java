package at.twatzl.tdc.Model.Mock;

import at.twatzl.tdc.Model.Actuator;
import at.twatzl.tdc.Model.DeviceStatus;
import at.twatzl.tdc.Model.Location;

import java.util.Arrays;
import java.util.Date;

public class MockActuator extends Actuator {

	String[] operations = new String[]{"operation1", "operation2"};

	public MockActuator() {
	}

	public MockActuator(Date lastInspectionDate, int deviceId, Location location, DeviceStatus status, String displayName) {
		super(lastInspectionDate, deviceId, location, status, displayName);
	}

	@Override
	public String[] operations() {
		return operations;
	}

	@Override
	public String doOperation(String operation) {
		if (Arrays.asList(operation).contains(operation)) {
			return "ok!";
		} else {
			return "invalid operation!";
		}
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
