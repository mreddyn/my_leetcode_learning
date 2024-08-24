package com.leetcode.easy;

import java.util.Arrays;

public class MaximumSumWithExactlyKElements {
    public int maximizeSum(int[] nums, int k) {
        int maxSum = 0, n = nums.length;
        Arrays.sort(nums);
        while (k-- > 0) {
            int lastEle = nums[n - 1];
            maxSum += lastEle;
            nums[n - 1] = lastEle + 1;
        }
        return maxSum;
    }

    public int maximizeSumApproachTwo(int[] nums, int k) {
        int maxSum = 0, maxEle = 0;
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
            maxEle = Math.max(maxEle, num);
        }

        while (k-- > 0) {
            maxSum += maxEle;
            maxEle++;
        }

        return maxSum;
    }
}
