package at.twatzl.tdc;

import at.twatzl.tdc.Model.Actuator;
import at.twatzl.tdc.Model.DeviceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ActuatorController {

	@Autowired
	private TDCData data;

	@RequestMapping(value = "/actuator/failed", method = RequestMethod.GET)
	@ResponseBody
	public List<Actuator> failedActuators() {
		return getFailedActuators();
	}

	@RequestMapping(value = "/actuator/{deviceId}/{operation}", method = RequestMethod.POST)
	@ResponseBody
	public String operateActuator(@PathVariable int deviceId, @PathVariable String operation) {
		return data.getActuatorById(deviceId).doOperation(operation);
	}

	@RequestMapping(value = "/actuator/{deviceId}/listOperations", method = RequestMethod.GET)
	@ResponseBody
	public String[] listOperations(@PathVariable int deviceId) {
		return data.getActuatorById(deviceId).operations();
	}

	private List<Actuator> getFailedActuators() {
		List<Actuator> failedActuators = new LinkedList<>();
		List<Actuator> actuators = data.getActuators();
		for (Actuator actuator : actuators) {
			if (actuator.status == DeviceStatus.Failure) {
				failedActuators.add(actuator);
			}
		}

		return failedActuators;
	}

}
