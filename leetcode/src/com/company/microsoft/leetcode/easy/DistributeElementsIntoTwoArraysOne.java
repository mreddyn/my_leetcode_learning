package com.company.microsoft.leetcode.easy;

public class DistributeElementsIntoTwoArraysOne {
    public int[] resultArray(int[] nums) {
        /*
         * TO merge two different arrays into one, we can separately add elements of
         * nums into two lists
         * and merge them at last but we will be declaring two additional lists.
         * Instead of that we can declare one large array of size 101 (as stated in
         * constraint that nums[i] <= 100)
         * Add first array elements to one side of array starting from 1 and add second
         * array elements to
         * same array starting from 51. At last we can add all these elements from this
         * large array to nums back.
         */
        int firstArrayIndex = 1, secondArrayIndex = 51;
        int[] count = new int[101];
        count[firstArrayIndex] = nums[0];
        count[secondArrayIndex] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (count[firstArrayIndex] > count[secondArrayIndex]) {
                count[++firstArrayIndex] = nums[i];
            } else {
                count[++secondArrayIndex] = nums[i];
            }
        }

        int finalArrayIndex = 0;
        for (int i = 1; i < 101; i++) {
            if (count[i] > 0) {
                nums[finalArrayIndex++] = count[i];
            }
        }
        return nums;
    }
}
