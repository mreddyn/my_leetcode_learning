package com.leetcode_daily_challenge;

import java.util.Arrays;

public class SortIntegersByTheNumberOfOneBits {
    private int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 10001 + arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10001;
        }
        return arr;
    }

    public static void main(String[] args) {
        SortIntegersByTheNumberOfOneBits sortIntegersByTheNumberOfOneBits = new SortIntegersByTheNumberOfOneBits();
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] result = sortIntegersByTheNumberOfOneBits.sortByBits(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
