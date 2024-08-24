package com.leetcode.easy;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        /*
         * 
         */
        int operations = 0, maxVal = 0;
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
            maxVal = Math.max(maxVal, num);
        }

        int curMin = 0, prevMin = 0;
        for (int i = 1; i < 101; i++) {
            if (count[i] == 0) {
                continue;
            }
            curMin = curMin - prevMin;
            maxVal = maxVal - curMin;
            prevMin = curMin;
            operations++;
            if (maxVal <= 0) {
                break;
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        MakeArrayZeroBySubtractingEqualAmounts mAmounts = new MakeArrayZeroBySubtractingEqualAmounts();
        System.out.println(mAmounts.minimumOperations(new int[] { 1, 5, 0, 3, 5 }));
        System.out.println(mAmounts.minimumOperations(new int[] { 0 }));
    }
}
