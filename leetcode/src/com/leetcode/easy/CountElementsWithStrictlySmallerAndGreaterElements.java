package com.leetcode.easy;

import java.util.HashMap;

public class CountElementsWithStrictlySmallerAndGreaterElements {
    public int countElements(int[] nums) {
        int strictlyElementsCount = 0;
        var map = new HashMap<Integer, Integer>();
        int minElement = Integer.MAX_VALUE, maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            if (num > minElement && num < maxElement) {
                strictlyElementsCount += map.get(num);
            }
        }
        return strictlyElementsCount;
    }

    public int countElementsApproachTwo(int[] nums) {
        int strictlyElementsCount = 0;
        int minElement = Integer.MAX_VALUE, maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
        }

        for (int num : nums) {
            if (num > minElement && num < maxElement) {
                strictlyElementsCount++;
            }
        }

        return strictlyElementsCount;
    }
}
