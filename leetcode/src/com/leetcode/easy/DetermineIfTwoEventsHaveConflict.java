package com.leetcode.easy;

public class DetermineIfTwoEventsHaveConflict {

    public boolean haveConflict(String[] event1, String[] event2) {
        /*
         * Given 2 segment [left1, right1], [left2, right2],
         * how can we check whether they overlap?
         * If these two intervals overlap, there should exist a value x,
         * left1 <= x <= right1 && left2 <= x <= right2
         * so that
         * max(left1, left2) <= x <= min(right1, right 2)
         * so that
         * left1 <= right2 && left2 <= right1
         * 
         * These two are the sufficient and necessary conditions,
         * for two interval overlaps.
         */
        int left1 = getTimeInMinutes(event1[0]);
        int right1 = getTimeInMinutes(event1[1]);
        int left2 = getTimeInMinutes(event2[0]);
        int right2 = getTimeInMinutes(event2[1]);

        if (Math.max(left1, left2) <= Math.min(right1, right2)) {
            return true;
        }

        return false;
    }

    private int getTimeInMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));
        int convertedTime = hours * 60 + minutes;
        return convertedTime;
    }
}
