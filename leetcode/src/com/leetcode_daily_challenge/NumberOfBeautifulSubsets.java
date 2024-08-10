package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBeautifulSubsets {
    Map<Integer, Integer> freqMap;

    private int beautifulSubsets(int[] nums, int k) {
        freqMap = new HashMap<>();
        int beautifulSubsetsCount = backtrack(nums, k, 0) - 1;
        return beautifulSubsetsCount;
    }

    private int backtrack(int[] nums, int k, int index) {
        if (index == nums.length) {
            return 1;
        }
        int result = backtrack(nums, k, index + 1);
        if (!freqMap.containsKey(nums[index] - k) && !freqMap.containsKey(nums[index] + k)) {
            freqMap.put(nums[index], freqMap.getOrDefault(nums[index], 0) + 1);
            result += backtrack(nums, k, index+1);
            freqMap.put(nums[index], freqMap.get(nums[index]) - 1);
            if (freqMap.get(nums[index]) == 0) {
                freqMap.remove(nums[index]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfBeautifulSubsets nunBeautifulSubsets = new NumberOfBeautifulSubsets();
        nunBeautifulSubsets.beautifulSubsets(null, 0);
    }
}
