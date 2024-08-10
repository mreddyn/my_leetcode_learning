package com.leetcode.easy;

public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        /*
         * Compare all neighbor elements in nums (a,b).
         * The case "a > b" can happen only at least once.
         * Since the array might be rotated, we also need to check the first and last
         * element too.
         * If it is rotated then first element should be greater or equal than last
         * element.
         */
        int n = nums.length, k = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                k++;
            }
        }

        if (k == 0) {
            // no rotations.
            return true;
        }

        if (k == 1 && nums[0] >= nums[n - 1]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfArrayIsSortedAndRotated cAndRotated = new CheckIfArrayIsSortedAndRotated();
        System.out.println(cAndRotated.check(new int[] { 3, 4, 5, 1, 2 }));
        System.out.println(cAndRotated.check(new int[] { 2, 1, 3, 4 }));
        System.out.println(cAndRotated.check(new int[] { 1, 2, 3 }));
    }
}
