package ru.frigesty.utils;

import java.util.HashMap;
import java.util.Map;

public class DateUtils {

    public static int getDaysInMonth(String month, int year) {
        Map<String, Integer> monthDays = new HashMap<>();
        monthDays.put("January", 31);
        monthDays.put("February", isLeapYear(year) ? 29 : 28);
        monthDays.put("March", 31);
        monthDays.put("April", 30);
        monthDays.put("May", 31);
        monthDays.put("June", 30);
        monthDays.put("July", 31);
        monthDays.put("August", 31);
        monthDays.put("September", 30);
        monthDays.put("October", 31);
        monthDays.put("November", 30);
        monthDays.put("December", 31);

        return monthDays.getOrDefault(month, 0);
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}