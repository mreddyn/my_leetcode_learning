package com.leetcode.easy;

import java.util.Arrays;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public int minimumSum(int num) {
        /*
         * Minimum sum is possible when after splitting the digits, sorting those digits
         * in
         * increasing order, and choosing one from start and one from end.
         * We will do this until no more digits are allowed.
         */
        int minSum = 0, index = 0;
        int[] digits = new int[4];
        while (num > 0) {
            digits[index++] = num % 10;
            num = num / 10;
        }

        Arrays.sort(digits);
        int new1 = 0, new2 = 0;
        new1 = digits[0] * 10 + digits[3];
        new2 = digits[1] * 10 + digits[2];
        minSum = new1 + new2;
        return minSum;
    }

    public static void main(String[] args) {
        MinimumSumOfFourDigitNumberAfterSplittingDigits mDigits = new MinimumSumOfFourDigitNumberAfterSplittingDigits();
        System.out.println(mDigits.minimumSum(2932));
    }
}
