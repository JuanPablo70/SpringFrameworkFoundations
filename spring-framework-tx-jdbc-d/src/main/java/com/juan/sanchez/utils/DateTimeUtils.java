package com.juan.sanchez.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtils {

	public static LocalDateTime now() {
		return LocalDateTime.now();
	}

	public static String nowFormatted(LocalDateTime localDateTime) {
		return localDateTime.format(dateTimeFormatter());
	}

	public static long durationAsMillis(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		return ChronoUnit.MILLIS.between(startDateTime, endDateTime);
	}

	private static DateTimeFormatter dateTimeFormatter() {
		return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");
	}

	private DateTimeUtils() {

	}

}