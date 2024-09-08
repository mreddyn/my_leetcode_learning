package com.company.microsoft.leetcode.easy;

public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        int n = s.length(), sum = 0;
        for (int i = 0; i < n; i++) {
            int val = (s.charAt(i) - 'a') + 1;
            sum += (val < 10) ? val : (val % 10 + val / 10);
        }

        k--;
        while (k-- > 0 && sum >= 10) {
            sum = digitsSum(sum);
        }

        return sum;
    }

    private int digitsSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
