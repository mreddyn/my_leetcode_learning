package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysTwo {
    public int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> nums2FreqCount = new HashMap<>();
        for (int num : nums2) {
            nums2FreqCount.put(num, nums2FreqCount.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < m; i++) {
            if (nums2FreqCount.containsKey(nums1[i])) {
                resultList.add(nums1[i]);
                nums2FreqCount.put(nums1[i], nums2FreqCount.get(nums1[i]) - 1);
                if (nums2FreqCount.get(nums1[i]) == 0) {
                    nums2FreqCount.remove(nums1[i]);
                }
            }
        }

        return resultList.stream().mapToInt(x -> x).toArray();
    }
}
