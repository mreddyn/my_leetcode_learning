package com.company.amazon.leetcode.easy;

public class RepeatedSubStringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 1) {
            return false;
        }
        /*
         * TO form a string from multiple copies of substring, the substring needs to
         * divide the string
         * Also it should be part of prefix.
         * e.g. s = abcdabcd
         * prefix a : aaaaaaaa != abcdabcd
         * prefix ab : ababababab != abcdabcd
         * prefix abc does not divide 8
         * prefix abcd : abcdabcd == abcdabcd
         */

        for (int i = 1; i <= n / 2; i++) {
            StringBuilder sb = new StringBuilder();
            int prefixStringLength = i - 0;
            if (n % prefixStringLength != 0) {
                continue;
            }
            String prefixString = s.substring(0, i);
            // make multiple copies of prefixString until its length matches s
            while (sb.length() < n) {
                sb.append(prefixString);
                if (sb.length() == n) {
                    break;
                }
            }
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubStringPattern rPattern = new RepeatedSubStringPattern();
        System.out.println(rPattern.repeatedSubstringPattern("abcdabcd"));
        System.out.println(rPattern.repeatedSubstringPattern("aba"));
        System.out.println(rPattern.repeatedSubstringPattern("abab"));
        System.out.println(rPattern.repeatedSubstringPattern("abcabcabcabc"));
    }
}
