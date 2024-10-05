package com.company.amazon.leetcode.easy;

public class ArmstrongNumber {
    public boolean isArmstrong(int n) {
        int k = getNumberOfDigits(n);
        int digitKthPowerSum = getDigitKthPower(n, k);
        return n == digitKthPowerSum;
    }

    private int getNumberOfDigits(int num) {
        int digitsCount = 0;
        while (num > 0) {
            digitsCount++;
            num = num / 10;
        }
        return digitsCount;
    }

    private int getDigitKthPower(int num, int k) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, k);
            num = num / 10;
        }
        return sum;
    }
}
