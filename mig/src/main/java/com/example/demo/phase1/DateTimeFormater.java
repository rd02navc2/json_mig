package com.example.demo.phase1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormater {

	public static String getDateForm() {
		Date date = new Date();

//		DateFormat dateFormat = new SimpleDateFormat("EE-MM-dd-yyyy");//星期六-09-01-2012
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		String x = dateFormat.format(date);
		// System.out.println(x);
		return x;

	}
	
	public static String getYearForm() {
		Date date = new Date();

//		DateFormat dateFormat = new SimpleDateFormat("EE-MM-dd-yyyy");//星期六-09-01-2012
		DateFormat dateFormat = new SimpleDateFormat("yyyy");

		String x = dateFormat.format(date);
		// System.out.println(x);
		return x;

	}

	
	public static void main(String[] args) {
		String x = DateTimeFormater.getYearForm();
		System.out.println(x);
	}

}
