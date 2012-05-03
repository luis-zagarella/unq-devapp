package ar.edu.unq.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.WicketRuntimeException;

public class DateUtils {

	public static Date getDate(final String pattern) {

		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.parse(pattern);
		} catch (ParseException e) {
			throw new WicketRuntimeException(e);
		}
	}

}
