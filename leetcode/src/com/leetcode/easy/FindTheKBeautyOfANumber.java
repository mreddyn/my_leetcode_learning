package com.leetcode.easy;

public class FindTheKBeautyOfANumber {
    public int divisorSubstrings(int num, int k) {
        /*
         * Process the num from right to left.
         * Take k digits from num by dividing the num by 10^k, this gives the last k
         * digits(window).
         * Check if this remainder is a divisor of num or not.
         */
        int kBeautyCount = 0;
        int pow = (int) Math.pow(10, k);
        for (int n = num; n > 0; n /= 10) {
            int remainder = n % pow;
            if (remainder != 0 && num % remainder == 0) {
                kBeautyCount++;
            }

            if (n / pow == 0) {
                // No digits to the left can contribute to divisor's size being k.
                break;
            }
        }

        return kBeautyCount;
    }
}
