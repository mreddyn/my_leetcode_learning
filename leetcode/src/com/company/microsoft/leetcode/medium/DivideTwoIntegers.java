package com.company.microsoft.leetcode.medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        int quotient = 0;
        while (dividend - divisor <= 0) {
            quotient--;
            dividend -= divisor;
        }

        if (negatives != 1) {
            quotient = -quotient;
        }

        return quotient;
    }
}
