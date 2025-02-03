package com.leetcode_contest.contest_434;

import java.util.HashMap;

public class MaximumFrequencyAfterSubArrayOperation {
    public int maxFrequency(int[] nums, int k) {
        int max_frequency = 0;

        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            int frequency = map.get(num);
            if (frequency > max_frequency) {
                max_frequency = frequency;
            }
        }

        return max_frequency + map.get(k);
    }

    public static void main(String[] args) {
        MaximumFrequencyAfterSubArrayOperation obj = new MaximumFrequencyAfterSubArrayOperation();

        // Example 1
        int[] nums1 = { 1, 2, 3, 4, 5, 6 };
        int k1 = 1;
        System.out.println(obj.maxFrequency(nums1, k1)); // should be 2

        // Example 2
        int[] nums2 = { 10, 2, 3, 4, 5, 5, 4, 3, 2, 2 };
        int k2 = 10;
        System.out.println(obj.maxFrequency(nums2, k2)); // should be 4
    }
}
