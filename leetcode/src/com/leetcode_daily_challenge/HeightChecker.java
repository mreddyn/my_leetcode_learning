package com.leetcode_daily_challenge;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int notMatchingIndicesCount = 0, n = heights.length;
        int[] freqMap = new int[101];
        for (int height : heights) {
            freqMap[height]++;
        }

        int[] sortedHeights = new int[n];
        int sortedHeightsIndex = 0;
        for (int i = 0; i < 101; i++) {
            int freq = freqMap[i];
            while (freq-- > 0) {
                sortedHeights[sortedHeightsIndex++] = i;
            }
        }

        // check the indices where the heights is not matched
        for (int i = 0; i < n; i++) {
            if (heights[i] != sortedHeights[i]) {
                notMatchingIndicesCount++;
            }
        }

        return notMatchingIndicesCount;
    }
}
