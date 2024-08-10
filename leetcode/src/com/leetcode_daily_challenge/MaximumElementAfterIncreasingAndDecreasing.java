package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MaximumElementAfterIncreasingAndDecreasing {
    private int maximumElementAfterIncreasingAndDecreasing(int[] arr) {
        int n = arr.length;
        int[] diff = new int[n - 1];
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        boolean isDiffLessThanOrEqualToOne = true;
        for (int i = 0; i < n - 1; i++) {
            if (diff[i] > 1) {
                isDiffLessThanOrEqualToOne = false;
                break;
            }
        }
        if (arr[0] == 1 && isDiffLessThanOrEqualToOne) {
            return maxElementInArray(arr);
        } else if (arr[0] != 1 && isDiffLessThanOrEqualToOne) {
            return n;
        } else if (arr[0] != 1 && !isDiffLessThanOrEqualToOne) {
            return n;
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (diff[i] > 1) {
                    arr[i + 1] = arr[i] + 1;
                }
            }
            return maxElementInArray(arr);
        }
    }

    private int maxElementInArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumElementAfterIncreasingAndDecreasing maxElementAfterIncreasingAndDecreasing = new MaximumElementAfterIncreasingAndDecreasing();
        System.out.println(maxElementAfterIncreasingAndDecreasing
                .maximumElementAfterIncreasingAndDecreasing(new int[] { 1, 2, 3, 4, 5 }));
    }
}
