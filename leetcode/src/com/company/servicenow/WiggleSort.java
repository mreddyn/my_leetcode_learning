package com.company.servicenow;

public class WiggleSort {
    private static void wiggleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        wiggleSort(new int[] { 3, 1, 5, 2 });
    }
}
