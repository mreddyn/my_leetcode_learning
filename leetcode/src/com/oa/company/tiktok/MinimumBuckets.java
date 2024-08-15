package com.oa.company.tiktok;

import java.util.HashMap;
import java.util.Map;

public class MinimumBuckets {
    // https://leetcode.com/discuss/interview-question/4880834/TikTok-OA-question.-can-anyone-please-answer-this-question

    public static int minBuckets(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxBuckets = 0;

        // Iterate over each element's frequency to determine the minimum buckets
        // required
        for (int freq : freqMap.values()) {
            // Calculate the minimum bucket size for this frequency
            int bucketSize = (int) Math.floor(freq / 2.0) + 1;
            int requiredBuckets = (int) Math.ceil(freq / (double) bucketSize);
            maxBuckets = Math.max(maxBuckets, requiredBuckets);
        }

        return maxBuckets;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5, 1, 1, 1, 1 };
        int[] arr2 = { 4, 4, 4, 4, 4, 4, 4, 4 };
        int[] arr3 = { 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9 };

        System.out.println(minBuckets(arr1)); // Output depends on x
        System.out.println(minBuckets(arr2)); // Output depends on x
        System.out.println(minBuckets(arr3)); // Output depends on x
    }
}
