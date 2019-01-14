package at.twatzl.tdc.Model;

import java.util.Date;

public class SensorData {

	public Date timestamp;
	public String message;

	public SensorData(Date timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}
}
