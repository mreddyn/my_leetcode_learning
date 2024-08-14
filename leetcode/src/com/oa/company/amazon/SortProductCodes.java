package com.oa.company.amazon;

import java.util.Arrays;

public class SortProductCodes {
    public String[] sortProductCodes(String order, String[] productCodes) {
        int[] charOrder = new int[26];
        for (int i = 0; i < 26; i++) {
            char c = order.charAt(i);
            charOrder[c - 'a'] = i;
        }

        // Define a custom comparator that uses the 'orderMap' for comparison
        Arrays.sort(productCodes, (a, b) -> {
            int len = Math.min(a.length(), b.length());
            for (int i = 0; i < len; i++) {
                char charA = a.charAt(i);
                char charB = b.charAt(i);
                if (charA != charB) {
                    return charOrder[charA - 'a'] - charOrder[charB - 'a'];
                }
            }
            // If one string is a prefix of the other, the shorter string is considered
            // smaller
            return a.length() - b.length();
        });

        return productCodes;
    }

    public static void main(String[] args) {
        SortProductCodes sCodes = new SortProductCodes();
        String[] result = sCodes.sortProductCodes("abcdefghijklmnopqrstuvwxyz", new String[] { "adc", "abc" });
        for (String s : result) {
            System.out.println(s);
        }
    }
}
