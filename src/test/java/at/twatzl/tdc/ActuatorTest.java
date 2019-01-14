package at.twatzl.tdc;

import at.twatzl.tdc.Model.Actuator;
import at.twatzl.tdc.Model.DeviceStatus;
import at.twatzl.tdc.Model.Location;
import at.twatzl.tdc.Model.Mock.MockActuator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ActuatorTest {
	@Test
	public void testActuatorCreation() {

		Date lastInspectionDate = TestUtil.parseDate("2018-12-01");
		Location location = new Location(1.2141, 121.1241);
		Actuator actuator = new MockActuator(
			lastInspectionDate,
				1,
				location,
				DeviceStatus.Operational,
				"test actuator"
		);

		Assert.assertEquals(location, actuator.location);
		Assert.assertEquals(DeviceStatus.Operational, actuator.status);
		Assert.assertEquals(lastInspectionDate, actuator.lastInspectionDate);
	}
}
