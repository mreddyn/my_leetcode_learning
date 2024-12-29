package com.leetcode.medium;

import java.util.HashMap;

public class CountTheNumberOfGoodSubArrays {
    public long countGood(int[] nums, int k) {
        long res = 0;
        int n = nums.length, pairCount = 0;
        var map = new HashMap<Integer, Integer>();

        for (int end = 0, start = 0; end < n; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            // get the frequency of current number and calculate how many pairs we can form
            int freq = map.get(nums[end]);
            pairCount += freq - 1;

            while (pairCount >= k) {
                // if we have atleast k pairs we can calculate the good sub arrays.
                // the number of good subarrays will be 1+(remaining elements outside of window)
                res += (n - end);

                // now after calculating we can resize the window
                map.put(nums[start], map.get(nums[start]) - 1);

                // since we removed an element we need to update the pairCount
                pairCount -= map.getOrDefault(nums[start], 0);

                map.remove(nums[start], 0);
                start++;
            }

        }

        return res;
    }
}
