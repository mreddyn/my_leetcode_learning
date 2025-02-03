package com.oa.company.microsoft;

import java.util.HashMap;
import java.util.Map;

public class FindMaxSumWithSameFirstAndLastDigit {
    public static int firstAndLastDigitSum(int[] arr) {
        // Map from "firstDigit,lastDigit" -> array of length 2 for the top two largest
        // numbers
        Map<String, int[]> map = new HashMap<>();

        for (int val : arr) {
            int firstDigit = getFirstDigit(val);
            int lastDigit = getLastDigit(val);

            String key = firstDigit + "," + lastDigit;

            // Retrieve or create the top-two array
            int[] topTwo = map.get(key);
            if (topTwo == null) {
                // Initialize with minimal possible values
                topTwo = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE };
                map.put(key, topTwo);
            }

            // Update topTwo if this val is in the top 2 for that key
            if (val > topTwo[0]) {
                topTwo[1] = topTwo[0];
                topTwo[0] = val;
            } else if (val > topTwo[1]) {
                topTwo[1] = val;
            }
        }

        // Now, compute the best sum across all digit pairs
        int maxSum = 0;
        for (int[] topTwo : map.values()) {
            // Only if we have at least 2 valid values
            if (topTwo[1] > Integer.MIN_VALUE) {
                int sum = topTwo[0] + topTwo[1];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    private static int getFirstDigit(int x) {
        x = Math.abs(x); // if negatives are possible
        while (x >= 10) {
            x /= 10;
        }
        return x;
    }

    private static int getLastDigit(int x) {
        x = Math.abs(x); // if negatives are possible
        return x % 10;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 36, 45, 306, 415 };
        System.out.println(firstAndLastDigitSum(nums)); // 460
    }
}
