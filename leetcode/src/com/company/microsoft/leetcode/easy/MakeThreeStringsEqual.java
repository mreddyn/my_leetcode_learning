package com.company.microsoft.leetcode.easy;

public class MakeThreeStringsEqual {
    public int findMinimumOperations(String s1, String s2, String s3) {
        /*
         * Find the longest common prefix of three strings.
         * and for each string calculate the difference of total length - longest common
         * prefix length (This tells us that the number of chars we need to delete,
         * which are not matching).
         * Finally total operations is sum of all the difference.
         */
        int minOperations = 0;
        String[] strs = new String[] { s1, s2, s3 };
        String longestCommonPrefix = findLongestCommonPrefix(strs);
        if (longestCommonPrefix.length() == 0) {
            return -1;
        }

        int lcpSize = longestCommonPrefix.length();
        for (String str : strs) {
            int difference = str.length() - lcpSize;
            minOperations += difference;
        }

        return minOperations;
    }

    private String findLongestCommonPrefix(String[] strs) {
        int minLength = Math.min(strs[0].length(), Math.min(strs[1].length(), strs[2].length()));
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < minLength) {
            if (strs[0].charAt(index) == strs[1].charAt(index) && strs[1].charAt(index) == strs[2].charAt(index)) {
                sb.append(strs[0].charAt(index));
                index++;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
