package com.leetcode.easy;

public class DayOfTheYear {
    public int dayOfYear(String date) {
        /*
         * date = "2019-01-09"
         * 1 January 31
         * 2 February 28 (29 in leap years)
         * 3 March 31
         * 4 April 30
         * 5 May 31
         * 6 June 30
         * 7 July 31
         * 8 August 31
         * 9 September 30
         * 10 October 31
         * 11 November 30
         * 12 December 31
         */
        int[] daysForEachMonth = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int dayOfTheYear = 0, day = 0, month, year;
        day = Integer.parseInt(date.substring(8, 10));
        month = Integer.parseInt(date.substring(5, 7));
        year = Integer.parseInt(date.substring(0, 4));
        boolean isLeapYear = isLeapYear(year);
        if (isLeapYear) {
            daysForEachMonth[1]++;
        }
        for (int monthIndex = 0; monthIndex < month; monthIndex++) {
            dayOfTheYear += daysForEachMonth[monthIndex];
        }
        dayOfTheYear += day;
        return dayOfTheYear;
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
