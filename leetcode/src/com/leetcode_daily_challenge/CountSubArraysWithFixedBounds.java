package com.leetcode_daily_challenge;

public class CountSubArraysWithFixedBounds {
    private long countSubArrays(int[] nums, int minK, int maxK) {
        long subArraysCount = 0;
        int n = nums.length, subArrayStartIndex = 0, latestMinIndex = -1, latestMaxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                subArrayStartIndex = i + 1;
                latestMinIndex = latestMaxIndex = -1;
            }

            if (nums[i] == minK) {
                latestMinIndex = i;
            }
            if (nums[i] == maxK) {
                latestMaxIndex = i;
            }
            subArraysCount += Math.max(0L, Math.min(latestMinIndex, latestMaxIndex) - subArrayStartIndex + 1);
        }
        return subArraysCount;
    }

    public static void main(String[] args) {
        CountSubArraysWithFixedBounds countSubArraysWithFixedBounds = new CountSubArraysWithFixedBounds();
        System.out.println(countSubArraysWithFixedBounds.countSubArrays(new int[] { 1, 1, 1, 1 }, 1, 1));
    }
}
