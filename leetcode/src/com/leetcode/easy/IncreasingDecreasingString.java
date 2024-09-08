package com.leetcode.easy;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        /*
         * TO solve this problem we need to count the frequency of chars in string s.
         * Maintain a index (or pointer) which travels from left to right and right to
         * left when it goes
         * out of bounds (26 or -1).
         * We need to grab a character when the index is a pointing to a char in string
         * s.
         * We will continue this until we exhaust all the chars in the string s.
         */
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder(n);
        int totalChars = n, countIndex = 0, direction = 1;
        while (totalChars > 0) {
            if (count[countIndex] > 0) {
                sb.append((char) (countIndex + 'a'));
                count[countIndex]--;
                totalChars--;
            }

            countIndex += direction;

            if (countIndex == 26) {
                direction = -1;
                countIndex--;
            }
            if (countIndex == -1) {
                direction = 1;
                countIndex++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IncreasingDecreasingString iDecreasingString = new IncreasingDecreasingString();
        System.out.println(iDecreasingString.sortString("aaaabbbbcccc"));
        System.out.println(iDecreasingString.sortString("rat"));
    }
}
