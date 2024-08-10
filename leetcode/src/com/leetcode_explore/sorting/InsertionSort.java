package com.leetcode_explore.sorting;

public class InsertionSort {
    private void insertionSort(int[] nums) {
        for (int index = 1; index < nums.length; index++) {
            int currentIndex = index;
            while (currentIndex > 0 && nums[currentIndex] < nums[currentIndex - 1]) {
                swap(nums, currentIndex, currentIndex - 1);
                currentIndex--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        InsertionSort iSort = new InsertionSort();
        int[] nums = { 5, 4, 3, 2, 1 };
        iSort.insertionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
