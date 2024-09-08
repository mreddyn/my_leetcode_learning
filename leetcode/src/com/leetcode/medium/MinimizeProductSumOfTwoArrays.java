package com.leetcode.medium;

import java.util.Arrays;

public class MinimizeProductSumOfTwoArrays {
    public int minProductSum(int[] nums1, int[] nums2) {
        int productSum = 0, n = nums1.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums2Index = n - 1;
        for (int i = 0; i < n; i++) {
            productSum += nums1[i] * nums2[nums2Index--];
        }

        return productSum;
    }
}
