package com.leetcode.easy;

public class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        int sum = 0, sign = 1;
        while (n > 0) {
            int remainder = n % 10;
            sign = sign * -1;
            sum += sign * remainder;
            n = n / 10;
        }

        return sum * sign;
    }

    public static void main(String[] args) {
        AlternatingDigitSum aDigitSum = new AlternatingDigitSum();
        System.out.println(aDigitSum.alternateDigitSum(10));
    }
}
