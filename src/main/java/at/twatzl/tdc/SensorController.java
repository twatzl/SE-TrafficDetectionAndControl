package at.twatzl.tdc;

import at.twatzl.tdc.Model.DeviceStatus;
import at.twatzl.tdc.Model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class SensorController {

	@Autowired
	private TDCData data;

	@RequestMapping(value = "/sensor/failed", method = RequestMethod.GET)
	public List<Sensor> failedSensors() {
		return getFailedSensors();
	}

	private List<Sensor> getFailedSensors() {
		List<Sensor> failedSensors = new LinkedList<>();
		List<Sensor> sensors = data.getSensors();
		for (Sensor sensor: sensors) {
			if (sensor.status == DeviceStatus.Failure) {
				failedSensors.add(sensor);
			}
		}

		return failedSensors;
	}
}
