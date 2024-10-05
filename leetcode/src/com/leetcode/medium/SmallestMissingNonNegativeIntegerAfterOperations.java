package com.leetcode.medium;

import java.util.HashMap;

public class SmallestMissingNonNegativeIntegerAfterOperations {
    public int findSmallestInteger(int[] nums, int value) {
        /*
         * Maintain a hashMap to keep track of the numbers after applying
         * operations(num%value).
         * After inserting all nums, iterate through 0 and check return first missing
         * element.
         */
        int smallestMissingInteger = 0;
        var count = new HashMap<Integer, Integer>();

        for (int num : nums) {
            // if num is negative, then we need to make it positive
            if (num < 0) {
                num = (num % value) + value;
            }
            int remainder = num % value;

            if (count.containsKey(remainder)) {
                // if map already has a number then we can use value to the remainder
                // for a new value.
                // i.e, remainder, remainder+1*value, remainder+2*value...
                int freq = count.get(remainder);
                int newNum = remainder + freq * value;
                count.put(newNum, 1);

                // increment existing number frequency (remainder)
                count.put(remainder, freq + 1);
            } else {
                count.put(remainder, 1);
            }
        }

        System.out.println(count);

        while (count.containsKey(smallestMissingInteger)) {
            smallestMissingInteger++;
        }

        return smallestMissingInteger;
    }
}
