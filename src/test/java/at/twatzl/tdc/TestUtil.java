package at.twatzl.tdc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil {

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			System.out.println("invalid date format");
			return null;
		}
	}

}
