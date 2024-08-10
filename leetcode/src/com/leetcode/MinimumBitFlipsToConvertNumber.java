package com.leetcode;

public class MinimumBitFlipsToConvertNumber {
    private int minBitFlips(int start, int goal) {
        int minBitFlipsCount = 0, xorOfStartAndGoal = start ^ goal;
        minBitFlipsCount = countSetBits(xorOfStartAndGoal);
        return minBitFlipsCount;
    }

    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumBitFlipsToConvertNumber minimumBitFlipsToConvertNumber = new MinimumBitFlipsToConvertNumber();
        System.out.println(minimumBitFlipsToConvertNumber.minBitFlips(10, 7));
    }
}
