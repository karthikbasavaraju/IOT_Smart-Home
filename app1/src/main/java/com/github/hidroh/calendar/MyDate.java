package com.github.hidroh.calendar;

import java.util.Date;

/**
 * Created by kbasa on 6/5/2018.
 */

public class MyDate {
    
    Integer sYear;
    Integer sMonth;
    Integer sDay;
    Integer sHour;
    Integer sMinute;
    String device;
    String status;
    String temperature="24.4";
    Integer eYear;
    Integer eMonth;
    Integer eDay;
    Integer eHour;
    Integer eMinute;

    public MyDate(Long startTime, String title, Long endTime){
        Date start = new Date(startTime);
        sYear = start.getYear();
        sMonth = start.getMonth();
        sDay = start.getDate();
        sHour = start.getHours();
        sMinute = start.getMinutes();

        String[] temp = title.split(" ");
        this.device = temp[2];
        this.status = temp[1];
        if(temp.length==4)
            this.temperature = temp[3];

        Date end = new Date(endTime);
        eYear = end.getYear();
        eMonth = end.getMonth();
        eDay = end.getDate();
        eHour = end.getHours();
        eMinute = end.getMinutes();

    }

    public Integer getsYear() {
        return sYear;
    }

    public void setsYear(Integer sYear) {
        this.sYear = sYear;
    }

    public Integer getsMonth() {
        return sMonth;
    }

    public void setsMonth(Integer sMonth) {
        this.sMonth = sMonth;
    }

    public Integer getsDay() {
        return sDay;
    }

    public void setsDay(Integer sDay) {
        this.sDay = sDay;
    }

    public Integer getsHour() {
        return sHour;
    }

    public void setsHour(Integer sHour) {
        this.sHour = sHour;
    }

    public Integer getsMinute() {
        return sMinute;
    }

    public void setsMinute(Integer sMinute) {
        this.sMinute = sMinute;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Integer geteYear() {
        return eYear;
    }

    public void seteYear(Integer eYear) {
        this.eYear = eYear;
    }

    public Integer geteMonth() {
        return eMonth;
    }

    public void seteMonth(Integer eMonth) {
        this.eMonth = eMonth;
    }

    public Integer geteDay() {
        return eDay;
    }

    public void seteDay(Integer eDay) {
        this.eDay = eDay;
    }

    public Integer geteHour() {
        return eHour;
    }

    public void seteHour(Integer eHour) {
        this.eHour = eHour;
    }

    public Integer geteMinute() {
        return eMinute;
    }

    public void seteMinute(Integer eMinute) {
        this.eMinute = eMinute;
    }

    public String toString(){
        return "Turn "+status+" "+device;
    }
}
