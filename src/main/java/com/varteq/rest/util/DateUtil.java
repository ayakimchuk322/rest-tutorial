package com.varteq.rest.util;

import com.varteq.rest.model.CalendarDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateUtil {

    private static final String DATE_FORMAT = "dd-MM-yyyy";

    public static String getDateFromMilliseconds() {
        return LocalDate
                .now()
                .format(DateTimeFormatter.ofPattern(DATE_FORMAT));

    }

    public static String getDayOfWeek(String date) {
        return LocalDate
                .parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT))
                .getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.US);
    }

    public static CalendarDate getDateInfo(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT));

        CalendarDate calendarDate = new CalendarDate();

        calendarDate.setDate(localDate.toString());
        calendarDate.setYear(localDate.getYear());
        calendarDate.setMonth(localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.US));
        calendarDate.setDayOfMonth(localDate.getDayOfMonth());
        calendarDate.setDayOfWeek(localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US));
        calendarDate.setDayOfYear(localDate.getDayOfYear());

        return calendarDate;
    }
}
