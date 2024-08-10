package com.leetcode_daily_challenge;

public class SortColors {
    private void sortColors(int[] nums) {
        int n = nums.length, zeroIndex, oneIndex;
        // first move only zeros to the left
        zeroIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // move zero to front
                int temp = nums[i];
                nums[i] = nums[zeroIndex];
                nums[zeroIndex] = temp;
                zeroIndex++;
            }
        }

        // now move ones to the left (after zeros)
        oneIndex = zeroIndex;
        for (int i = zeroIndex; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[oneIndex];
                nums[oneIndex] = temp;
                oneIndex++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[] { 2, 0, 2, 1, 1, 0, 0, 2, 1, 0 });
    }
}
