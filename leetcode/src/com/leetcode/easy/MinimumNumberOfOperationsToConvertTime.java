package com.leetcode.easy;

public class MinimumNumberOfOperationsToConvertTime {
    public int convertTime(String current, String correct) {
        /*
         * we need to convert both current and correct times to minutes to calculate
         * difference.
         * After getting difference we will greedily reduce the difference by adding 60,
         * 15, 5, and 1
         * operations += diff/change
         * diff = diff/change
         */
        int operations = 0, diff = 0;
        diff = convertTimeToMinutes(correct) - convertTimeToMinutes(current);

        int[] changes = new int[] { 60, 15, 5, 1 };
        for (int change : changes) {
            if (diff == 0) {
                return operations;
            }
            operations += diff / change;
            diff = diff % change;
        }
        return operations;
    }

    private int convertTimeToMinutes(String time) {
        String[] strs = time.split(":");
        int convertedTime = Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
        return convertedTime;
    }
}
