package com.company.facebook.medium;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size(), minDiff = Integer.MAX_VALUE;
        var minutes = new int[n];

        for (int i = 0; i < n; i++) {
            var time = timePoints.get(i).split(":");
            int hrs = Integer.parseInt(time[0]);
            int mins = Integer.parseInt(time[1]);
            minutes[i] = hrs * 60 + mins;
        }

        // sort the minutes array
        Arrays.sort(minutes);

        // minimum difference is between adjacent elements
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minutes[i] - minutes[i - 1], minDiff);
        }

        // since time is circular we also need to calculate between first and last
        // circular difference
        minDiff = Math.min(minDiff, 24 * 60 - minutes[n - 1] + minutes[0]);

        return minDiff;
    }

    public int findMinDifferenceApproachTwo(List<String> timePoints) {
        int minDiff = Integer.MAX_VALUE;
        var mark = new boolean[24 * 60];
        for (String time : timePoints) {
            var t = time.split(":");
            int hrs = Integer.parseInt(t[0]);
            int mins = Integer.parseInt(t[1]);
            int minutes = hrs * 60 + mins;
            if (mark[minutes]) {
                return 0;
            }
            mark[minutes] = true;
        }

        // calculate the minDiff as all elements are adjacent
        // also store first and last timePoints
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE, prev = 0;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    minDiff = Math.min(minDiff, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }

        // calculate the circular difference
        minDiff = Math.min(minDiff, 24 * 60 - last + first);

        return minDiff;
    }
}
