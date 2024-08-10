package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        int pairsCount = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pairsCount += map.getOrDefault(nums[i] - k, 0);
            pairsCount += map.getOrDefault(nums[i] + k, 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return pairsCount;
    }

    public static void main(String[] args) {
        CountNumberOfPairsWithAbsoluteDifferenceK cAbsoluteDifferenceK = new CountNumberOfPairsWithAbsoluteDifferenceK();
        System.out.println(cAbsoluteDifferenceK.countKDifference(new int[] { 1, 2, 2, 1 }, 1));
    }
}
