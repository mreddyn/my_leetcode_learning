package com.leetcode.medium;

public class TakeKOfEachCharacterFromLeftOrRight {
    public int takeCharacters(String s, int k) {
        /*
         * Find the maximum window size of the string such that count of all A,B,C chars
         * in rest of the string is atleast K
         * 
         * Why taking maximum ?
         * 
         * Because we need to find minimum number of minutes taking char from left or
         * right side such all a, b, c char are at least K.
         * 
         * By taking max. window in middle we get smaller window in left and right side.
         */
        int n = s.length(), res = -1;
        var count = new int[3]; // map to keep track of freq of a, b, and c
        // find the frequency of a,b, and c to see if it is possible to pick k chars
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        if (count[0] < k || count[1] < k || count[2] < k) {
            // not possible to pick exact k characters of each a,b,c
            return -1;
        }

        for (int windowEnd = 0, windowStart = 0; windowEnd < n; windowEnd++) {
            count[s.charAt(windowEnd) - 'a']--;
            while (count[s.charAt(windowEnd) - 'a'] < k) {
                count[s.charAt(windowStart) - 'a']++;
                windowStart++;
            }

            res = Math.max(res, windowEnd - windowStart + 1);
        }

        return n - res;
    }
}
