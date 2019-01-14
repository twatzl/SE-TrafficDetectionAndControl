package at.twatzl.tdc;

import at.twatzl.tdc.Model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {

	@Autowired
	private TDCData data;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/devices/list")
	@ResponseBody
	public Device[] list() {
		List<Device> sensorList = data.getDeviceList();
		Device[] sensors = new Device[sensorList.size()];
		sensorList.toArray(sensors);

		return sensors;
	}

}
