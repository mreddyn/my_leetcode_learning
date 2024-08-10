package com.company.microsoft.leetcode.medium;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        /*
         * 1. Start from the End and find the index of that number which is smaller that
         * its right neighbor
         * 2. Swap these two numbers (smaller number and its right neighbor which is
         * greater)
         * 3. Finally sort the suffix array which starts from index which we swapper
         * greater number.
         */

        int n = nums.length;
        if (n == 1) {
            return;
        }

        // find the pivot element where a number is smaller than its right neighbor
        int i = n - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i == 0) {
            // nums is already largest permutation
            Arrays.sort(nums);
            return;
        }
        // find the rightmost greater element than pivot element
        // let nums[i-1] be pivot
        int j = n - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }

        // swap the pivot element and pivot successor
        int temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp;

        // Reverse the suffix
        int left = i, right = n - 1;
        while (left < right) {
            temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
        return;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 5, 3, 3, 0 };
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
