package com.company.microsoft.leetcode.easy;

public class FindLuckyIntegerInArray {
    public int findLucky(int[] arr) {
        int largestLuckyNumber = -1, n = arr.length, maxVal = 1;
        int[] count = new int[501];
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
            maxVal = Math.max(maxVal, arr[i]);
        }

        for (int i = maxVal; i > 0; i--) {
            if (i == count[i]) {
                return i;
            }
        }

        return largestLuckyNumber;
    }
}
