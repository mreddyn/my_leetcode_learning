package com.leetcode_daily_challenge;

public class LargestThreeSameDigitNumberString {
    private String largestGoodInteger(String num) {
        String result = "";
        int n = num.length();
        int windowSize = 3;
        int windowStart = 0;
        int windowEnd = windowStart + windowSize;
        int maxWindow = Integer.MIN_VALUE;
        while (windowEnd <= n) {
            String window = num.substring(windowStart, windowEnd);
            if (window.charAt(0) == window.charAt(1) && window.charAt(1) == window.charAt(2)) {
                int windowInt = Integer.parseInt(window);
                if (windowInt > maxWindow) {
                    maxWindow = windowInt;
                    result = window;
                }

            }
            windowStart++;
            windowEnd++;
        }
        return result;
    }

    public static void main(String[] args) {
        LargestThreeSameDigitNumberString largestThreeSameDigitNumberString = new LargestThreeSameDigitNumberString();
        System.out.println(largestThreeSameDigitNumberString.largestGoodInteger("2300019"));
    }
}
