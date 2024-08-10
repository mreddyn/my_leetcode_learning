package com.leetcode_daily_challenge;

public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    private int minOperations(int[] nums, int k) {
        int minOperationsCount = 0, n = nums.length, numsXORResult = 0;
        for (int i = 0; i < n; i++) {
            numsXORResult = numsXORResult ^ nums[i];
        }
        String numsXORResultBinaryString = Integer.toBinaryString(numsXORResult);
        String kBinaryString = Integer.toBinaryString(k);
        int kBinaryStringSize = kBinaryString.length(),
                numsXORResultBinaryStringSize = numsXORResultBinaryString.length();
        int kBinaryStringIndex = kBinaryStringSize - 1,
                numsXORResultBinaryStringIndex = numsXORResultBinaryStringSize - 1;
        while (kBinaryStringIndex >= 0 && numsXORResultBinaryStringIndex >= 0) {
            char a = kBinaryString.charAt(kBinaryStringIndex);
            char b = numsXORResultBinaryString.charAt(numsXORResultBinaryStringIndex);
            if (a != b) {
                minOperationsCount++;
            }
            kBinaryStringIndex--;
            numsXORResultBinaryStringIndex--;
        }
        while (kBinaryStringIndex >= 0) {
            if (kBinaryString.charAt(kBinaryStringIndex) == '1') {
                minOperationsCount++;
            }
            kBinaryStringIndex--;
        }
        while (numsXORResultBinaryStringIndex >= 0) {
            if (numsXORResultBinaryString.charAt(numsXORResultBinaryStringIndex) == '1') {
                minOperationsCount++;
            }
            numsXORResultBinaryStringIndex--;
        }
        System.out.println(numsXORResultBinaryString + "  " + kBinaryString);
        return minOperationsCount;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeArrayXOREqualToK minimumNumberOfOperationsToMakeArrayXOREqualToK = new MinimumNumberOfOperationsToMakeArrayXOREqualToK();
        int[] nums = { 2, 1, 3, 4 };
        int k = 1;
        System.out.println(minimumNumberOfOperationsToMakeArrayXOREqualToK.minOperations(nums, k));
    }
}
