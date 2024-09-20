package com.company.microsoft.leetcode.medium;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
         * Instead of counting overlapping intervals we will count the non-overlapping
         * intervals
         * and substitute it from total number of intervals.
         * We will sort the intervals by their end times.
         * Iterate through the array if the current start time is greater or equal than
         * previous interval end time then we increase the non-overlapping count.
         * Finally return the overlapping count.
         */
        int removedIntervalsCount = 0, n = intervals.length;

        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int end = intervals[0][1], nonOverlappingCount = 1;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                nonOverlappingCount++;
            }
        }

        removedIntervalsCount = n - nonOverlappingCount;
        return removedIntervalsCount;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals nIntervals = new NonOverlappingIntervals();
        nIntervals.eraseOverlapIntervals(new int[][] { { 1, 2 }, { 3, 4 }, { 2, 3 }, { 1, 3 } });
    }
}
