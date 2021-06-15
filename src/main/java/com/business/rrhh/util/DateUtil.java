package com.business.rrhh.util;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String format(LocalDate localDate) {

        return localDate.format(FORMATTER);

    }

    public static LocalTime getTimeBetween(LocalTime start, LocalTime end) {
        return castToLocalTime(Duration.between(start, end));
    }


    public static LocalTime castToLocalTime(Duration duration) {

        int hours = (int) duration.toHours();
        int minutes = (int) ((duration.getSeconds() % (60 * 60)) / 60);
        int seconds = (int) (duration.getSeconds() % 60);

        return LocalTime.of(hours, minutes, seconds);
    }
}
