package com.leetcode_daily_challenge;

public class BinarySubArraysWithSum {
    private int numSubArrayWithSum(int[] nums, int goal) {
        return atMostSubArray(nums, goal) - atMostSubArray(nums, goal - 1);
    }

    private int atMostSubArray(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int n;
        n = nums.length;
        int winStart, winEnd, winSum, subArraysCount;
        winStart = 0;
        winSum = 0;
        subArraysCount = 0;
        for (winEnd = 0; winEnd < n; winEnd++) {
            winSum += nums[winEnd];
            while (winSum > goal) {
                winSum -= nums[winStart];
                winStart++;
            }
            subArraysCount += (winEnd - winStart + 1);
        }
        return subArraysCount;
    }

    public static void main(String[] args) {
        BinarySubArraysWithSum binarySubArraysWithSum = new BinarySubArraysWithSum();
        System.out.println(binarySubArraysWithSum.numSubArrayWithSum(new int[] { 0, 0, 0, 0, 0 }, 0));
    }
}
