package com.company.doordash;

import java.util.ArrayList;

import java.util.List;

public class PrintLongestCommonSubsequenceOfTwoStringArrays {
    private Integer[][] memo;

    private int lcs(String[] s1, String[] s2) {
        int m = s1.length;
        int n = s2.length;
        memo = new Integer[m + 1][n + 1];
        return lcsHelper(s1, s2, 0, 0);
    }

    private int lcsHelper(String[] s1, String[] s2, int i, int j) {
        if (i == s1.length || j == s2.length) {
            memo[i][j] = 0;
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int use = 0;
        int skip_i = 0;
        int skip_j = 0;

        if (s1[i].equals(s2[j])) {
            use = 1 + lcsHelper(s1, s2, i + 1, j + 1);
        } else {
            skip_i = lcsHelper(s1, s2, i + 1, j);
            skip_j = lcsHelper(s1, s2, i, j + 1);
        }

        int best = Math.max(use, Math.max(skip_i, skip_j));
        memo[i][j] = best;
        return best;
    }

    private List<String> constructLcs(String[] s1, String[] s2) {
        List<String> lcs = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < s1.length && j < s2.length) {
            if (s1[i].equals(s2[j])) {
                lcs.add(s1[i]);
                i++;
                j++;
            } else if (memo[i + 1][j] >= memo[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        return lcs;
    }

    public static void main(String[] args) {
        PrintLongestCommonSubsequenceOfTwoStringArrays obj = new PrintLongestCommonSubsequenceOfTwoStringArrays();
        String[] s1 = { "chilis", "albertsons", "walmart", "albertsons", "chilis", "mcdonalds", "burger king" };
        String[] s2 = { "chilis", "walmart", "chilis", "albertsons", "burger king", "applebees", "McDonalds" };
        int result = obj.lcs(s1, s2);
        System.out.println("Length of Longest Common Subsequence: " + result);

        List<String> lcs = obj.constructLcs(s1, s2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
