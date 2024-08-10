package com.leetcode;

public class SecondLargestDigitInAString {
    private int secondHighest(String s) {
        int size = s.length(), first = -1, second = -1;
        int[] digitCount = new int[10];
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57) {
                digitCount[c - '0']++;
            }
        }
        for (int i = 0; i <= 9; i++) {
            if (digitCount[i] > 0) {
                second = first;
                first = i;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        SecondLargestDigitInAString secondLargestDigitInAString = new SecondLargestDigitInAString();
        System.out.println(secondLargestDigitInAString.secondHighest("abc111"));
    }
}
