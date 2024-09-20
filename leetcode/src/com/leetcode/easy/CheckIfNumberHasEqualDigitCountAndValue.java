package com.leetcode.easy;

public class CheckIfNumberHasEqualDigitCountAndValue {
    public boolean digitCount(String num) {
        var digitCountMap = new int[10];
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            digitCountMap[digit]++;
        }
        
        for (int digit = 0; digit < n; digit++) {
            int value = num.charAt(digit) - '0';
            int freq = digitCountMap[digit];
            if (value != freq) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfNumberHasEqualDigitCountAndValue cAndValue = new CheckIfNumberHasEqualDigitCountAndValue();
        System.out.println(cAndValue.digitCount("1210"));
    }
}
