package com.company.amazon.leetcode.medium;

import java.util.Arrays;

public class TheNumberOfSmallestUnOccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        // storing the starTime and endTime of targetFriend
        var targetTime = times[targetFriend];
        // sort the times by arrivalTime or startTime
        Arrays.sort(times, (a, b) -> (a[0] - b[0]));

        int n = times.length;
        // storing the endTimes of friends to calculate in which chair they sit
        int[] chairTime = new int[n];
        for (int[] time : times) {
            for (int i = 0; i < n; i++) {
                // for each friend we will check if a chair is available or not
                // if it is available then we assign that chair
                if (time[0] >= chairTime[i]) {
                    chairTime[i] = time[1];
                    if (Arrays.equals(time, targetTime)) {
                        return i;
                    }
                    // continue to next friend
                    break;
                }
            }
        }

        return 0;
    }

    public int smallestChairApproachTwo(int[][] times, int targetFriend) {
        
        return 0;
    }
}
