package com.company.amazon.leetcode.easy;

public class NumberOfDaysInAMonth {
    public int numberOfDays(int year, int month) {
        final int[] days = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }

    private boolean isLeapYear(int year) {
        if(year % 400 == 0) {
            return true;
        }
        if(year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }
}
