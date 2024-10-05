package com.leetcode.easy;

import java.util.HashMap;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        /*
         * For each different number a in A,
         * we need to count its frequency and it first occurrence index.
         * 
         * If a has the maximum frequency,
         * update the degree = count[a] and res = i - first[A[i]] + 1.
         * 
         * If a is one of the numbers that has the maximum frequency,
         * update the res = min(res, i - first[A[i]] + 1)
         */
        int res = 0, degree = 0, n = nums.length;
        var freqMap = new HashMap<Integer, Integer>();
        var firstIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            firstIndexMap.putIfAbsent(num, i);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            if (freqMap.get(num) > degree) {
                // if the current element has greater frequency
                degree = freqMap.get(num);
                res = i - firstIndexMap.get(num) + 1;
            } else if (freqMap.get(num) == degree) {
                // if the current element has same frequency
                // then update the distance (sub array of min length)
                res = Math.min(res, i - firstIndexMap.get(num) + 1);
            }
        }

        return res;
    }
}
