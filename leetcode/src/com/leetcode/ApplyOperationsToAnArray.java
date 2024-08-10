package com.leetcode;

public class ApplyOperationsToAnArray {
    private int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
            }
        }

        // move non zero elements to the left the array
        int nonZeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroIndex];
                nums[nonZeroIndex] = temp;
                nonZeroIndex++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        ApplyOperationsToAnArray aOperationsToAnArray = new ApplyOperationsToAnArray();
        aOperationsToAnArray.applyOperations(new int[] { 1, 2, 2, 1, 1, 0 });
    }
}
