package com.leetcode.medium;

public class NumberOfSubStringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        /*
         * we will maintain a sliding window which will keep track fo chars for 'a',
         * 'b', and 'c'
         * whenever the sliding window size is 3, then the valid substrings will be
         * 1+(remaining chars outside the window)
         * 
         * for example : abcabc
         * for start = 0, end = 2, n = 6 => abc, abca, abcab, abcabc
         * for start = 1, end = 3, n = 6 => bca, bcab, bcabc
         * for start = 2, end = 4, n = 6 => cab, cabc
         * for start = 3, end = 5, n = 6 => abc
         */
        if (s == null || s.length() < 3) {
            return 0;
        }
        int n = s.length(), res = 0;
        var map = new int[100];
        for (int end = 0, start = 0; end < n; end++) {
            map[s.charAt(end)]++;

            while (map['a'] > 0 && map['b'] > 0 && map['c'] > 0) {
                res += (n - end);
                // resize the window
                map[s.charAt(start)]--;
                start++;
            }
        }

        return res;
    }
}
