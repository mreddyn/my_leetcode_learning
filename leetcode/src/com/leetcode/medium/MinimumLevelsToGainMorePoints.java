package com.leetcode.medium;

public class MinimumLevelsToGainMorePoints {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        for (int i = 0; i < n; i++) {
            // convert all 0's to -1, since they decrease the points
            if (possible[i] == 0) {
                possible[i] = -1;
            }
        }

        // calculate the prefixSums
        var prefix = new int[n];
        var prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += possible[i];
            prefix[i] = prefixSum;
        }

        // calculate the suffixSums
        var suffix = new int[n];
        var suffixSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixSum += possible[i];
            suffix[i] = suffixSum;
        }

        // find the first prefixSum which is greater than suffixSum
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] > suffix[i + 1]) {
                return i + 1;
            }
        }

        return -1;
    }
}
