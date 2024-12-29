package com.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumBeautyAfterApplyingOperations {
    public int maximumBeauty(int[] nums, int k) {
        /*
         * if we calculate the range for each number it comes as [nums[i]-k, nums[i]-k]
         * e.g. nums = [4,6,1,2] k = 2
         * for 4 => [2,6]
         * for 6 => [4,8]
         * for 1 => [-1,3]
         * for 2 => [0,4]
         * so after sorting these intervals => [-1,3],[0,4][2,6][4,8].
         * Now if we treat these are meeting intervals, we need to find the at any point
         * of time
         * how many intersections are there and return the maximum intersections.
         */
        int n = nums.length;
        var intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = nums[i] - k;
            intervals[i][1] = nums[i] + k;
        }

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int maxMeetingPoints = 0;
        var pQueue = new PriorityQueue<Integer>();
        for (var interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (pQueue.isEmpty()) {
                // if there is only one meeting then we push the ending time to queue
                pQueue.add(end);
            } else {
                // if there are already meetings then we see if it clashes
                while (!pQueue.isEmpty() && start > pQueue.peek()) {
                    pQueue.poll();
                }
                pQueue.add(end);
            }

            maxMeetingPoints = Math.max(maxMeetingPoints, pQueue.size());
        }
        return maxMeetingPoints;
    }
}
