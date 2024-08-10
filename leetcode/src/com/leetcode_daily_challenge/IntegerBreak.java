package com.leetcode_daily_challenge;

public class IntegerBreak {
    private int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (remainder == 1) {
            return (int) Math.pow(3, (n / 3) - 1) * 4;
        } else {
            return (int) Math.pow(3, n / 3) * 2;
        }
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(3));
    }
}
