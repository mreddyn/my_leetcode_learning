package com.company.facebook.medium;

import java.util.HashMap;

public class FindTheNumberOfGoodPairsTwo {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long goodPairsCount = 0;
        var factorsFreqMap = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            // calculate the factors for each num in nums1, and put them in the HashMap
            for (int i = 1; i * i <= num; i++) {
                if (i * i == num) {
                    factorsFreqMap.put(i, factorsFreqMap.getOrDefault(i, 0) + 1);
                } else if (num % i == 0) {
                    int factorOne = i;
                    int factorTwo = num / i;
                    factorsFreqMap.put(factorOne, factorsFreqMap.getOrDefault(factorOne, 0) + 1);
                    factorsFreqMap.put(factorTwo, factorsFreqMap.getOrDefault(factorTwo, 0) + 1);
                }
            }
        }

        for (int num : nums2) {
            // now for each num in nums2, check if a number (num*k) exists in factors map
            int key = num * k;
            if (factorsFreqMap.containsKey(key)) {
                goodPairsCount += factorsFreqMap.get(key);
            }
        }

        return goodPairsCount;
    }
}
