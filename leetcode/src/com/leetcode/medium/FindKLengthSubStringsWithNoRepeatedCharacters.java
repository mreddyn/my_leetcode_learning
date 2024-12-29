package com.leetcode.medium;

public class FindKLengthSubStringsWithNoRepeatedCharacters {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int n = s.length(), totalSubStrings = 0;
        var count = new int[128];
        for (int end = 0, start = 0; end < n; end++) {
            while (count[s.charAt(end)] > 0) {
                // whenever we see a character that is already in the window.
                // we move the window until that character is removed
                count[s.charAt(start)]--;
                start++;
            }

            // include the current character to the window
            count[s.charAt(end)]++;

            if (end - start + 1 == k) {
                // if window size equals k then increment sub strings count
                totalSubStrings++;

                // since there are k unique chars in the window already and next char
                // will come, so we decrement the window size by 1
                count[s.charAt(start)]--;
                start++;
            }
        }

        return totalSubStrings;
    }
}
