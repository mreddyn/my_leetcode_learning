package com.leetcode_daily_challenge;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int size = intervals.length;
        if (newInterval.length == 0) {
            return intervals;
        }
        if (size == 0) {
            return new int[][] { { newInterval[0], newInterval[1] } };
        }
        List<int[]> result = new LinkedList<>();
        int index = 0;
        // add all the intervals ending before newInterval starts
        while (index < size && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            index++;
        }

        // merge all overlapping intervals
        while (index < size && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        result.add(newInterval);

        // add the rest of intervals from intervals array
        while (index < size) {
            result.add(intervals[index]);
            index++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        insertInterval.insert(new int[][] { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } },
                new int[] { 4, 8 });
    }
}
