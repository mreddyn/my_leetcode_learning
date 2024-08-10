package com.leetcode_daily_challenge;

import java.util.ArrayDeque;

public class CountNumberOfNiceSubArrays {
    public int numberOfSubArrays(int[] nums, int k) {
        int niceSubArraysCount = 0, n = nums.length;
        ArrayDeque<Integer> oddIndicesQueue = new ArrayDeque<>();
        int initialGap = -1, lastPopped = -1;
        for (int i = 0; i < n; i++) {
            // if odd number then the index to the queue
            if (nums[i] % 2 == 1) {
                oddIndicesQueue.add(i);
            }

            // if the number of odd numbers in the queue exceed k then pop from front
            if (oddIndicesQueue.size() > k) {
                lastPopped = oddIndicesQueue.poll();
            }

            // if the number of odd numbers in the queue equals k then calculate sub arrays
            if (oddIndicesQueue.size() == k) {
                initialGap = oddIndicesQueue.peek() - lastPopped;
                niceSubArraysCount += initialGap;
            }
        }

        return niceSubArraysCount;
    }

    public int numberOfSubArraysApproachTwo(int[] nums, int k) {
        return numberOfSubArraysAtMostK(nums, k) - numberOfSubArraysAtMostK(nums, k - 1);
    }

    private int numberOfSubArraysAtMostK(int[] nums, int k) {
        int n = nums.length, niceSubArraysCount = 0;
        int windowEnd = 0, windowStart = 0, windowSize = 0;
        while (windowEnd < n) {
            windowSize += nums[windowEnd] % 2;
            while (windowSize > k) {
                windowSize -= nums[windowStart] % 2;
                windowStart++;
            }
            niceSubArraysCount += (windowEnd - windowStart + 1);
            windowEnd++;
        }

        return niceSubArraysCount;
    }

    public static void main(String[] args) {
        CountNumberOfNiceSubArrays cNiceSubArrays = new CountNumberOfNiceSubArrays();
        System.out.println(cNiceSubArrays.numberOfSubArrays(new int[] { 1, 1, 2, 1, 1 }, 3));
        System.out.println(cNiceSubArrays.numberOfSubArrays(new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, 2));
    }
}
