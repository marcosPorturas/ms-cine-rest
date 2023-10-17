package com.pe.web.cine.app.utilitario;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Util {

	public static String convertToStringDate(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd-MM-yyyy HH:mm:ss");
		return  date.format(formatter);
	}

	public static LocalDateTime convertToLocalDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(date,formatter);
	}

}
