package com.pe.web.cine.app.utilitario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

	public static String convertToStringDate(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd-MM-yyyy");
		return  date.format(formatter);
	}

	public static LocalDateTime convertToLocalDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd");
		return LocalDateTime.parse(date,formatter);
	}

}
