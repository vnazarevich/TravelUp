package com.epam.travelup.tour.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataParser {

	public static Timestamp  parseToSqlDate(String dateInString){
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
		
		Date date = null;
		System.out.println("START STRING DATE  " + dateInString);
		try {
	 
			date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));
	 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp  sqlDate = new Timestamp(date.getTime());

		System.out.println("utilDate:" + date);
		System.out.println("sqlDate:" + sqlDate);
		
		return sqlDate;
	}
}
