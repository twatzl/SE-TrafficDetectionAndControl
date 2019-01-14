package at.twatzl.tdc;

import at.twatzl.tdc.Model.Actuator;
import at.twatzl.tdc.Model.Device;
import at.twatzl.tdc.Model.Sensor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class TDCData {

	private Map<Integer, Device> deviceList;
	private Map<Integer, Sensor> sensorList;
	private Map<Integer, Actuator> actuatorList;

	public TDCData() {
		this.deviceList = new HashMap<>();
		this.sensorList = new HashMap<>();
		this.actuatorList = new HashMap<>();
	}

	public void addDevice(Sensor device) {
		this.deviceList.put(device.deviceId, device);
		this.sensorList.put(device.deviceId, device);
	}

	public void addDevice(Actuator device) {
		this.deviceList.put(device.deviceId, device);
		this.actuatorList.put(device.deviceId, device);
	}

	public List<Device> getDeviceList() {
		return new LinkedList<>(deviceList.values());
	}

	public Device getDeviceById(int id) {
		return deviceList.get(id);
	}

	public Sensor getSensorById(int id) {
		return sensorList.get(id);
	}

	public Actuator getActuatorById(int id) {
		return actuatorList.get(id);
	}

	public List<Sensor> getSensors() {
		return new LinkedList<>(sensorList.values());
	}

	public List<Actuator> getActuators() {
		return new LinkedList<>(actuatorList.values());
	}

	public void update() {
		for (Device d: deviceList.values()) {
			d.update();
		}
	}
}
