package com.company.microsoft.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        var mergedIntervals = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        int prevStartTime = intervals[0][0], prevEndTime = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int curStartTime = intervals[i][0];
            int curEndTime = intervals[i][1];

            if (curStartTime <= prevEndTime) {
                // intervals are overlapping, so merge them
                int newEndTime = Math.max(prevEndTime, curEndTime);
                prevEndTime = newEndTime;
            } else {
                // no overlapping then add previous interval to list
                mergedIntervals.add(new int[] { prevStartTime, prevEndTime });
                prevStartTime = curStartTime;
                prevEndTime = curEndTime;
            }
        }

        // add the last interval
        mergedIntervals.add(new int[] { prevStartTime, prevEndTime });

        return mergedIntervals.toArray(new int[0][]);
    }
}
