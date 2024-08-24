package com.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class FindSubSequenceOfLengthKWithLargestSum {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] sequence = new int[k];
        int[][] indexAndVal = new int[nums.length][2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            indexAndVal[i][0] = nums[i];
            indexAndVal[i][1] = i;
        }

        // sort the array by value
        Arrays.sort(indexAndVal, Comparator.comparingInt(a -> -a[0]));

        // grab k nums
        int[][] maxK = Arrays.copyOf(indexAndVal, k);

        // sort by index
        Arrays.sort(maxK, Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < k; i++) {
            sequence[i] = maxK[i][0];
        }

        return sequence;
    }
}
