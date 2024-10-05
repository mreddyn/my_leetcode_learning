package com.leetcode.medium;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 0, n = arr.length, curLen = 0;
        for (int i = 0; i < n; i++) {
            if (i >= 2 && ((arr[i - 2] > arr[i - 1] && arr[i - 1] < arr[i])
                    || (arr[i - 2] < arr[i - 1] && arr[i - 1] > arr[i]))) {
                // if the last three elements are turbulent then increment
                curLen++;
            } else if (i >= 1 && arr[i - 1] != arr[i]) {
                // the last three elements are not turbulent
                // but the last two elements are also not equal
                curLen = 2;
            } else {
                curLen = 1;
            }

            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }
}
