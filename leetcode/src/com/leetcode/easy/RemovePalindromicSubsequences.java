package com.leetcode.easy;

public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        /*
         * Since the s contains only two characters and we need to remove only
         * subsequences.
         * The subsequence does not need to be continuous.
         * if its empty string we can return 0 steps.
         * if s is a palindrome then we can remove entire string in one step.
         * if s is not a palindrome then we can remove all a chars in one step and
         * b chars in one step, so total 2 steps.
         */
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        if (isPalindrome(s, n)) {
            return 1;
        }

        return 2;
    }

    private boolean isPalindrome(String s, int n) {
        int left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
