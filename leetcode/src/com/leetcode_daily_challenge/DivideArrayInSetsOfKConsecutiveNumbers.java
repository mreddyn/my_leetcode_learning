package com.leetcode_daily_challenge;

import java.util.TreeMap;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (map.size() > 0) {
            int minElement = map.firstKey();
            int minElementFreq = map.get(minElement);
            for (int i = 0; i < k; ++i) {
                if (map.containsKey(minElement + i) && minElementFreq <= map.get(minElement + i)) {
                    map.put(minElement + i, map.get(minElement + i) - minElementFreq);
                    if (map.get(minElement + i) == 0) {
                        map.remove(minElement + i);
                    }
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        DivideArrayInSetsOfKConsecutiveNumbers dConsecutiveNumbers = new DivideArrayInSetsOfKConsecutiveNumbers();
        System.out.println(dConsecutiveNumbers.isPossibleDivide(new int[] { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 }, 3));
    }
}
