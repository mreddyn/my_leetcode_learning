package com.leetcode_patterns.twoPointers;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String result) {
        // case 1: the frequency of chars in start and result should be same.
        if (!canTransformHelper(start, result)) {
            return false;
        }

        // case 2: the 'L' can only move to left and 'R' can only move to right
        // so 'L' index in start should be greater or equal to 'L' index in result
        // and 'R' index in start should be lesser or equal to 'R' index in result
        int n = start.length(), i = 0, j = 0;
        while (i < n || j < n) {
            // skip 'X' chars in start and result strings
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }

            while (j < n && result.charAt(j) == 'X') {
                j++;
            }

            // if i and j reached end of string then they should be equal
            if (i == n || j == n) {
                return i == j;
            }

            // the chars should match
            if (start.charAt(i) != result.charAt(j)) {
                return false;
            }

            if (start.charAt(i) == 'R') {
                if (i > j) {
                    return false;
                }
            } else {
                if (i < j) {
                    return false;
                }
            }
            i++;
            j++;
        }

        return true;
    }

    private boolean canTransformHelper(String start, String result) {
        var count = new int[90];
        int n = start.length();
        for (int i = 0; i < n; i++) {
            count[start.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            count[result.charAt(i)]--;
            if (count[result.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
