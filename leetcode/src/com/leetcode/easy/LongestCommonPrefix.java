package com.leetcode.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // We compare characters from top to bottom on the same column (same character
        // index of the strings) before moving on to the next column.
        int firstStrLen = strs[0].length();
        for (int i = 0; i < firstStrLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix lPrefix = new LongestCommonPrefix();
        System.out.println(lPrefix.longestCommonPrefix(new String[] { "flowr", "fla", "flower", "flow", "flight" }));
    }
}
