package com.leetcode_daily_challenge;

public class MinimumCommonValue {
    private int getCommon(int[] nums1, int[] nums2) {
        int n, m, commonElement, firstArrayPointer, secondArrayPointer;
        n = nums1.length;
        m = nums2.length;
        commonElement = -1;
        firstArrayPointer = 0;
        secondArrayPointer = 0;
        while (firstArrayPointer < n && secondArrayPointer < m) {
            if (nums1[firstArrayPointer] == nums2[secondArrayPointer]) {
                commonElement = nums1[firstArrayPointer];
                break;
            } else if (nums1[firstArrayPointer] > nums2[secondArrayPointer]) {
                secondArrayPointer++;
            } else {
                firstArrayPointer++;
            }
        }

        return commonElement;
    }

    public static void main(String[] args) {
        MinimumCommonValue minimumCommonValue = new MinimumCommonValue();
        System.out.println(minimumCommonValue.getCommon(new int[] { 1, 2, 3 }, new int[] { 2, 4 }));
    }
}
