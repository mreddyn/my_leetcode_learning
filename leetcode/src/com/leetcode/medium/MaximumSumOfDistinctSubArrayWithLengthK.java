package com.leetcode.medium;

import java.util.HashSet;

public class MaximumSumOfDistinctSubArrayWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSubArraySum = 0, windowSum = 0;
        int n = nums.length, end = 0, start = 0;
        var seen = new HashSet<Integer>();

        for (end = 0; end < n; end++) {
            while (seen.contains(nums[end]) || seen.size() == k) {
                seen.remove(nums[start]);
                windowSum -= nums[start++];
            }

            windowSum += nums[end];
            seen.add(nums[end]);

            if (seen.size() == k) {
                maxSubArraySum = Math.max(maxSubArraySum, windowSum);
            }
        }

        return maxSubArraySum;
    }
}
