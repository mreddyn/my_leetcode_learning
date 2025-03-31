package com.company.doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeIntervals {
    // Map day abbreviations to numbers (mon=1, tue=2, …, sun=7)
    private static final HashMap<String, Integer> dayMap = new HashMap<>();
    static {
        dayMap.put("mon", 1);
        dayMap.put("tue", 2);
        dayMap.put("wed", 3);
        dayMap.put("thu", 4);
        dayMap.put("fri", 5);
        dayMap.put("sat", 6);
        dayMap.put("sun", 7);
    }

    class ParsedTime {
        int dayNumber;
        int hour;
        int minute;
        int totalMinutes;

        ParsedTime(int dayNumber, int hour, int minute) {
            this.dayNumber = dayNumber;
            this.hour = hour;
            this.minute = minute;
            this.totalMinutes = hour * 60 + minute;
        }
    }

    private ParsedTime parseTime(String timeStr) {
        var parts = timeStr.trim().toLowerCase().split("\\s+");
        var dayStr = parts[0];
        if (!dayMap.containsKey(dayStr)) {
            throw new IllegalArgumentException();
        }

        int dayNumber = dayMap.get(dayStr);

        var timePart = parts[1];
        var timeParts = timePart.split(":");
        if (timeParts.length != 2) {
            throw new IllegalArgumentException();
        }

        int hour;
        int minute;

        try {
            hour = Integer.parseInt(timeParts[0]);
            minute = Integer.parseInt(timeParts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (hour < 1 || hour > 12) {
            throw new IllegalArgumentException();
        }

        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException();
        }

        var meridiem = parts[2];

        // convert 12 hour format to 24 hour
        if (meridiem.equals("am")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }

        return new ParsedTime(dayNumber, hour, minute);
    }

    public List<String> getTimeIntervals(String startTime, String endTime) {
        var start = parseTime(startTime);
        var end = parseTime(endTime);

        if (start.dayNumber != end.dayNumber) {
            throw new IllegalArgumentException();
        }

        if (start.totalMinutes > end.totalMinutes) {
            throw new IllegalArgumentException("Start time must be before end time");
        }

        var res = new ArrayList<String>();

        for (int t = start.totalMinutes; t <= end.totalMinutes; t += 5) {
            int currentHour = t / 60;
            int currentMinute = t % 60;

            var formattedTime = start.dayNumber + String.format("%02d", currentHour)
                    + String.format("%02d", currentMinute);
            res.add(formattedTime);
        }

        return res;
    }

    public static void main(String[] args) {
        TimeIntervals timeIntervals = new TimeIntervals();
        String startTime = "mon 10:45 am";
        String endTime = "mon 11:00 am";
        List<String> intervals = timeIntervals.getTimeIntervals(startTime, endTime);
        System.out.println(intervals);
    }
}
