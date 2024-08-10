package com.leetcode_daily_challenge;

public class LargestOddNumberInString {
    private String largestOddNumber(String num) {
        int n = num.length();
        if (n == 0) {
            return "";
        }
        int index = n - 1;
        while (index >= 0) {
            if ((num.charAt(index) - '0') % 2 == 1) {
                break;
            }
            index--;
        }
        return num.substring(0, index + 1);
    }

    public static void main(String[] args) {
        LargestOddNumberInString largestOddNumberInString = new LargestOddNumberInString();
        System.out.println(largestOddNumberInString.largestOddNumber("52"));
    }
}
