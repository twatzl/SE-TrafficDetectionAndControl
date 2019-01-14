package at.twatzl.tdc;

import at.twatzl.tdc.Model.Device;
import at.twatzl.tdc.Model.DeviceStatus;
import at.twatzl.tdc.Model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DeviceController {

	@Autowired
	private TDCData data;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/devices/list", method = RequestMethod.GET)
	@ResponseBody
	public Device[] list() {
		List<Device> sensorList = data.getDeviceList();
		Device[] sensors = new Device[sensorList.size()];
		sensorList.toArray(sensors);

		return sensors;
	}

	@RequestMapping(value = "/device/{deviceId}/location", method = RequestMethod.GET)
	public Location location(@PathVariable int deviceId) {
		return data.getDeviceById(deviceId).location;
	}

	@RequestMapping(value = "/device/{deviceId}/status", method = RequestMethod.GET)
	public DeviceStatus status(@PathVariable int deviceId) {
		return data.getDeviceById(deviceId).status;
	}

	@RequestMapping(value = "/device/{deviceId}/inspectionCompleted", method = RequestMethod.POST)
	public void inspectionCompleted(@PathVariable int deviceId) {
		data.getDeviceById(deviceId).lastInspectionDate = new Date();
	}

	@RequestMapping(value = "/device/{deviceId}/lastInspectionDate", method = RequestMethod.GET)
	public Date lastInspectionDate(@PathVariable int deviceId) {
		return data.getDeviceById(deviceId).lastInspectionDate;
	}

	@RequestMapping(value = "/device/{deviceId}/connect", method = RequestMethod.POST)
	public void connect(@PathVariable int deviceId) {
		data.getDeviceById(deviceId).connect();
	}

	@RequestMapping(value = "/device/{deviceId}/shutdown", method = RequestMethod.POST)
	public void shutdown(@PathVariable int deviceId) {
		data.getDeviceById(deviceId).shutdown();
	}

}
