package com.zulkarnaen.login.requirement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	public static Date formatDateTime(String s) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		if (s == null || s.isEmpty()) {
			return null;
		}
		try {
			Date date;
			date = sf.parse(s);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static String formatDateStart(Date param) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(param);

		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);

		Date newFormatted = cal.getTime();

		String date = sdf.format(newFormatted);

		return date;
	}

}
