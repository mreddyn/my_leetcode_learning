package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    private int minOperations(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int numberOfOperations = 0;
        for (int key : freqMap.keySet()) {
            int value = freqMap.get(key);
            if (value == 1) {
                return -1;
            }
            if (value % 3 == 0) {
                numberOfOperations += value / 3;
            } else if (value % 3 == 1) {
                numberOfOperations += (value - 4) / 3 + 2;
            } else {
                numberOfOperations += (value - 2) / 3 + 1;
            }
        }
        return numberOfOperations;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeArrayEmpty m = new MinimumNumberOfOperationsToMakeArrayEmpty();
        int[] nums = { 2, 3, 3, 2, 2, 4, 2, 3, 4 };
        System.out.println(m.minOperations(nums));
    }
}
