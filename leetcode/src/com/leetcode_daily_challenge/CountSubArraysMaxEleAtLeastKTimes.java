package com.leetcode_daily_challenge;

import java.util.LinkedList;
import java.util.Queue;

public class CountSubArraysMaxEleAtLeastKTimes {
    private static long countSubArrays(int[] nums, int k) {
        long subArraysCount = 0, n = nums.length;
        int maxElement = nums[0];
        for (int i = 0; i < n; i++) {
            maxElement = Math.max(nums[i], maxElement);
        }
        Queue<Integer> maxElementIndices = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == maxElement) {
                maxElementIndices.add(i);
            }
            if (maxElementIndices.size() < k) {
                continue;
            }
            if (maxElementIndices.size() > k) {
                maxElementIndices.poll();
            }
            subArraysCount += maxElementIndices.peek() + 1;
        }
        return subArraysCount;
    }

    private static long countSubArraysApproachTwo(int[] nums, int k) {
        int n = nums.length, subArraysCount = 0, windowEnd, windowStart, maxElement = nums[0], maxElementCount;
        for (int i = 0; i < n; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }

        windowEnd = 0;
        windowStart = 0;
        maxElementCount = 0;
        while (windowEnd < n) {
            if (nums[windowEnd] == maxElement) {
                maxElementCount++;
            }
            if (maxElementCount >= k) {
                while (maxElementCount >= k) {
                    subArraysCount += n - windowEnd;
                    if (nums[windowStart] == maxElement) {
                        maxElementCount--;
                    }
                    windowStart++;
                }
            }
            windowEnd++;
        }
        return subArraysCount;
    }

    public static void main(String[] args) {
        System.out.println(countSubArrays(new int[] { 61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19,
                14, 58, 42, 82, 10, 82, 78, 15, 82 }, 2));
        System.out.println(
                countSubArraysApproachTwo(new int[] { 61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19,
                        14, 58, 42, 82, 10, 82, 78, 15, 82 }, 2));
    }
}
