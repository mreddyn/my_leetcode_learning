package com.leetcode_daily_challenge;

public class CalculateMoneyInLeetcodeBank {
    private int totalMoney(int n) {
        int totalMoney = 0;
        int a = 1;
        int d = 1;
        while (n > 0) {
            if (n >= 7) {
                totalMoney += (7 * (2 * a + 6 * d)) / 2;
            } else {
                totalMoney += (n * (2 * a + (n - 1) * d)) / 2;
            }
            a++;
            n -= 7;
        }
        return totalMoney;
    }

    public static void main(String[] args) {
        CalculateMoneyInLeetcodeBank calculateMoneyInLeetcodeBank = new CalculateMoneyInLeetcodeBank();
        System.out.println(calculateMoneyInLeetcodeBank.totalMoney(10));
    }
}
