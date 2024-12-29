package com.leetcode.easy;

import java.util.PriorityQueue;

public class LargestNumberAfterDigitsSwapsByParity {
    private PriorityQueue<Integer> oddDigits;
    private PriorityQueue<Integer> evenDigits;

    public int largestInteger(int num) {
        oddDigits = new PriorityQueue<>((a, b) -> b - a);
        evenDigits = new PriorityQueue<>((a, b) -> b - a);
        var num_str = String.valueOf(num);
        storeLargestOddAndEvenDigits(num_str);

        int res = 0, n = num_str.length();
        for (int i = 0; i < n; i++) {
            res = res * 10;
            // if we find a larger digit we swap it
            if (num_str.charAt(i) % 2 == 0) {
                // even digit
                res += evenDigits.poll();
            } else {
                res += oddDigits.poll();
            }
        }
        return res;
    }

    private void storeLargestOddAndEvenDigits(String num) {
        int n = num.length();
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) % 2 == 0) {
                evenDigits.add(num.charAt(i) - '0');
            } else {
                oddDigits.add(num.charAt(i) - '0');
            }
        }
    }
}
