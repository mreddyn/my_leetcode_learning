package com.leetcode.easy;

import java.util.HashSet;

public class CountNumbersWithUniqueDigitsTwo {
    public int numberCount(int a, int b) {
        int uniqueDigitsNumsCount = 0;
        for (int num = a; num <= b; num++) {
            if (isNumHasUniqueDigits(num)) {
                uniqueDigitsNumsCount++;
            }
        }

        return uniqueDigitsNumsCount;
    }

    private boolean isNumHasUniqueDigits(int num) {
        int[] digitCount = new int[10];
        while (num > 0) {
            int digit = num % 10;
            if (++digitCount[digit] > 1) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}
