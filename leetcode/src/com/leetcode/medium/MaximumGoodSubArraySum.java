package com.leetcode.medium;

import java.util.HashMap;

public class MaximumGoodSubArraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        /*
         * since |nums[i] = nums[j]| = k => nums[i] = k + nums[j] or nums[j] - k
         * for each nums[i] we will look for nums[j] + k and nums[j] - k
         * Store the minium prefix sum since we need max sub array sum.
         */
        long maxSubArraySum = Long.MIN_VALUE, prefixSum = 0;
        int n = nums.length;
        var valToMinPrefixSum = new HashMap<Integer, Long>();

        for (int i = 0; i < n; i++) {
            if (valToMinPrefixSum.getOrDefault(nums[i], Long.MAX_VALUE) > prefixSum) {
                valToMinPrefixSum.put(nums[i], prefixSum);
            }
            prefixSum += nums[i];

            // nums[j] + k
            if (valToMinPrefixSum.containsKey(nums[i] + k)) {
                // get the sub array sum
                long subArraySum = prefixSum - valToMinPrefixSum.get(nums[i] + k);
                maxSubArraySum = Math.max(maxSubArraySum, subArraySum);
            }

            // nums[j] - k
            if (valToMinPrefixSum.containsKey(nums[i] - k)) {
                long subArraySum = prefixSum - valToMinPrefixSum.get(nums[i] - k);
                maxSubArraySum = Math.max(maxSubArraySum, subArraySum);
            }
        }
        return maxSubArraySum == Long.MIN_VALUE ? 0 : maxSubArraySum;
    }
}
