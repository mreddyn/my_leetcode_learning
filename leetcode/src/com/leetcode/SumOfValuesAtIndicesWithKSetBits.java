package com.leetcode;

import java.util.List;

public class SumOfValuesAtIndicesWithKSetBits {
    private int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        if (k == 0) {
            return nums.get(0);
        }
        int sumOfKSetBitIndicesOfNums = 0, n = nums.size();
        for (int i = n - 1; i > 0; i--) {
            if (countSetBits(i) == k) {
                sumOfKSetBitIndicesOfNums += nums.get(i);
            }
        }

        return sumOfKSetBitIndicesOfNums;
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
        SumOfValuesAtIndicesWithKSetBits sumOfValuesAtIndicesWithKSetBits = new SumOfValuesAtIndicesWithKSetBits();
        sumOfValuesAtIndicesWithKSetBits.sumIndicesWithKSetBits(null, 0);
    }
}
