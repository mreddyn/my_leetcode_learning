package com.leetcode_explore.sorting;

public class SortColors {
    private void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int currentIndex = 0;
        while (currentIndex <= twoIndex) {
            if (nums[currentIndex] == 0) {
                swap(nums, currentIndex, zeroIndex);
                zeroIndex++;
                currentIndex++;
            } else if (nums[currentIndex] == 2) {
                swap(nums, currentIndex, twoIndex);
                twoIndex--;
            } else {
                currentIndex++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0, 1 };
        SortColors sc = new SortColors();
        sc.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
