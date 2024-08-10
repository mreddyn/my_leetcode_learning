package com.leetcode_daily_challenge;

public class SetMisMatch {
    private int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[nums.length + 1];
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 2) {
                result[0] = i;
            }
            if (count[i] == 0) {
                result[1] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SetMisMatch solution = new SetMisMatch();
        int[] result = solution.findErrorNums(new int[] { 1, 2, 2, 4 });
        for (int i : result) {
            System.out.println(i);
        }
    }
}
