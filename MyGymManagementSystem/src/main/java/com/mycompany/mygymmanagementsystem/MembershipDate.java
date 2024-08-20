/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rankychawich
 */
package com.mycompany.mygymmanagementsystem;

import java.io.Serializable;
import java.util.Calendar;

public class MembershipDate implements Serializable {
    private int day;
    private int month;
    private int year;

    public MembershipDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Calendar toCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); 
        return calendar;
    }
}







   

