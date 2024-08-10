package com.leetcode_daily_challenge;

public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1)
            return true;
        int increasingCount = 0;
        int decreasingCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                increasingCount++;
            }
            if (nums[i] <= nums[i - 1]) {
                decreasingCount++;
            }
        }
        return increasingCount == nums.length - 1 || decreasingCount == nums.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 5, 4, 4 };
        MonotonicArray ma = new MonotonicArray();
        System.out.println(ma.isMonotonic(nums));
    }

}
