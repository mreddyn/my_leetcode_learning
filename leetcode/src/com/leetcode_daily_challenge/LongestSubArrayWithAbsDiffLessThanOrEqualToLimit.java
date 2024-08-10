package com.leetcode_daily_challenge;

import java.util.PriorityQueue;

public class LongestSubArrayWithAbsDiffLessThanOrEqualToLimit {
    public int longestSubArray(int[] nums, int limit) {
        int longestSubArrayLength = 0, n = nums.length;
        /*
         * maintain a sliding window where the absolute difference between maximum and
         * minimum element
         * is less than or equal to the limit
         */
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int windowEnd = 0, windowStart = 0;
        while (windowEnd < n) {
            int curElement = nums[windowEnd];
            int curElementIndex = windowEnd;
            maxHeap.add(new int[] { curElement, curElementIndex });
            minHeap.add(new int[] { curElement, curElementIndex });
            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                windowStart = Math.min(maxHeap.peek()[1], minHeap.peek()[1]) + 1;
                while (maxHeap.peek()[1] < windowStart) {
                    maxHeap.poll();
                }
                while (minHeap.peek()[1] < windowStart) {
                    minHeap.poll();
                }
            }
            longestSubArrayLength = Math.max(longestSubArrayLength, windowEnd - windowStart + 1);

            windowEnd++;
        }
        return longestSubArrayLength;
    }
}
