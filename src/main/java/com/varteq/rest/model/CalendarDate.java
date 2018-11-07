package com.varteq.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarDate {

    private String date;
    private Integer year;
    private String month;
    @JsonProperty("day of month")
    private Integer dayOfMonth;
    @JsonProperty("day of week")
    private String dayOfWeek;
    @JsonProperty("day of year")
    private Integer dayOfYear;

    public CalendarDate() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDayOfYear() {
        return dayOfYear;
    }

    public void setDayOfYear(Integer dayOfYear) {
        this.dayOfYear = dayOfYear;
    }
}
