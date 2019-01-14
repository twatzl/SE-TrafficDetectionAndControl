package at.twatzl.tdc.Model;

import at.twatzl.tdc.Model.Mock.MockActuator;
import at.twatzl.tdc.Model.Mock.MockSensor;
import at.twatzl.tdc.TDCData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private TDCData data;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// do data initialization here

		Sensor sensor1 = new MockSensor(
				new Date(2018, 12, 10),
				1,
				new Location(1.29821, 5.1214),
				DeviceStatus.Operational,
				"Sensor 1",
				new LinkedList<>(Collections.singletonList(
						new SensorData(new Date(2018, 12, 31), "somemeasurement: 35")
				))
		);

		Actuator actuator1 =
				new MockActuator(
						new Date(2018, 12, 15),
						2,
						new Location(1.2145151, 8.123143),
						DeviceStatus.Failure,
						"Actuator 1"
				);

		data.addDevice(sensor1);
		data.addDevice(actuator1);
	}
}
