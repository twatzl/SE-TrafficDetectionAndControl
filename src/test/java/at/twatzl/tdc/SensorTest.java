package at.twatzl.tdc;

import at.twatzl.tdc.Model.DeviceStatus;
import at.twatzl.tdc.Model.Location;
import at.twatzl.tdc.Model.Mock.MockSensor;
import at.twatzl.tdc.Model.Sensor;
import at.twatzl.tdc.Model.SensorData;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

public class SensorTest {
	@Test
	public void testSensorCreation() {
		Date lastInspectionDate = TestUtil.parseDate("2018-12-01");
		Location location = new Location(1.2141, 121.1241);
		Sensor sensor = new MockSensor(
				lastInspectionDate,
				1,
				location,
				DeviceStatus.Operational,
				"test actuator",
				new LinkedList<>(Arrays.asList(
						new SensorData(TestUtil.parseDate("2019-01-01"), "foo"),
						new SensorData(TestUtil.parseDate("2019-01-01"), "bar"))
				)
		);

		Assert.assertEquals(location, sensor.location);
		Assert.assertEquals(DeviceStatus.Operational, sensor.status);
		Assert.assertEquals(lastInspectionDate, sensor.lastInspectionDate);
		Assert.assertEquals(2, sensor.getSensorData().size());
	}
}
