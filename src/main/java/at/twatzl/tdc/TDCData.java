package at.twatzl.tdc;

import at.twatzl.tdc.Model.Device;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TDCData {

	List<Device> deviceList;

	public TDCData() {
		this.deviceList = new LinkedList<>();
	}

	public List<Device> getDeviceList() {
		return deviceList;
	}
}
