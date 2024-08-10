package com.oa.company.amazon;

import java.util.Arrays;

public class LexicographicallySmallestPalindrome {
    public String computeEncodedProductName(String nameString) {
        /*
         * Split the string into two halves. Since the string is symmetrical, working
         * with the first half and reflecting changes on the second half is enough to
         * ensure the final string remains a palindrome.
         * Sort the first half to make it the smallest lexicographically.
         * Mirror the sorted first half to form the second half and combine them to
         * create the smallest lexicographical palindrome.
         */
        int n = nameString.length();

        // Get the first Half of the nameString
        char[] firstHalf = nameString.substring(0, n / 2).toCharArray();

        // sort the first half to make it lexicographically small
        Arrays.sort(firstHalf);
        StringBuilder smallestPalindrome = new StringBuilder();
        smallestPalindrome.append(firstHalf);

        // if n is odd then append middle char.
        if (n % 2 != 0) {
            smallestPalindrome.append(nameString.charAt(n / 2));
        }

        // append the first half after reversing it
        smallestPalindrome.append(new StringBuilder(new String(firstHalf)).reverse());

        return smallestPalindrome.toString();
    }

    public static void main(String[] args) {
        LexicographicallySmallestPalindrome lPalindrome = new LexicographicallySmallestPalindrome();
        System.out.println(lPalindrome.computeEncodedProductName("yxxy"));
    }
}
