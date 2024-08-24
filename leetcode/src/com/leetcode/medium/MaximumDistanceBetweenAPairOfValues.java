package com.leetcode.medium;

public class MaximumDistanceBetweenAPairOfValues {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, maxDistance = 0;
        int numsOneIndex = 0, numsTwoIndex = 0;
        while (numsOneIndex < m && numsTwoIndex < n) {
            if (nums1[numsOneIndex] > nums2[numsTwoIndex]) {
                numsOneIndex++;
            } else {
                maxDistance = Math.max(maxDistance, numsTwoIndex - numsOneIndex);
                numsTwoIndex++;
            }
        }
        return maxDistance;
    }
}
