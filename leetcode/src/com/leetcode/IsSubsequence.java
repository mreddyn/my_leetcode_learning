package com.leetcode;

public class IsSubsequence {
    private boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length(), sIndex, tIndex;
        for (sIndex = 0, tIndex = 0; sIndex < m && tIndex < n; tIndex++) {
            sIndex += (s.charAt(sIndex) == t.charAt(tIndex)) ? 1 : 0;
        }

        return sIndex == m;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }
}
