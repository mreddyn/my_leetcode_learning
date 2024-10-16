package com.leetcode.medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, k, n - 1);
        reverse(nums, 0, k - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        int temp = 0;
        while (left < right) {
            temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }
}