package com.leetcode.easy;

public class LexicographicallySmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        /*
         * Maintain two pointers left and right. left starts from index 0, and right
         * starts from
         * s.length-1
         * Compare the characters at two positions, if they are equal then continue.
         * Else check which char comes first and assign it to the other one.
         */
        int n = s.length(), left, right;
        left = 0;
        right = n - 1;
        char[] ch = s.toCharArray();
        while (left < right) {
            if (ch[left] != ch[right]) {
                if (ch[left] < ch[right]) {
                    ch[right] = ch[left];
                } else {
                    ch[left] = ch[right];
                }
            }
            left++;
            right--;
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        LexicographicallySmallestPalindrome lPalindrome = new LexicographicallySmallestPalindrome();
        System.out.println(lPalindrome.makeSmallestPalindrome("egcfe"));
        System.out.println(lPalindrome.makeSmallestPalindrome("abcd"));
    }
}
