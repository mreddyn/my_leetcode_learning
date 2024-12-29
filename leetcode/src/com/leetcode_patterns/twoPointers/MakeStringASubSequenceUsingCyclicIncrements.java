package com.leetcode_patterns.twoPointers;

public class MakeStringASubSequenceUsingCyclicIncrements {
    public boolean canMakeSubsequence(String str1, String str2) {
        /*
         * Maintain two pointers for str1 and str2.
         * Compare the chars where the pointers are pointing.
         * if chars are same we increment both pointers.
         * else we check for cyclic diff is one or more.
         * if cyclic diff is more then increment only first pointer.
         * 
         * Finally we will check if we are able to find str2 sequence in str1
         */
        int m = str1.length(), n = str2.length();
        if (n > m) {
            return false;
        }

        int first = 0, second = 0;
        while (first < m && second < n) {
            var firstChar = str1.charAt(first);
            var secondChar = str2.charAt(second);
            if (firstChar == secondChar) {
                // both chars are same.
                first++;
                second++;
            } else {
                // check if the cyclic diff is 1
                if (firstChar + 1 == secondChar || firstChar - secondChar == 25) {
                    first++;
                    second++;
                } else {
                    first++;
                }
            }
        }

        // check if we are able to perform cyclic increments to str1
        if (second < n) {
            return false;
        }
        return true;
    }
}
