package com.leetcode_daily_challenge;

import java.util.Arrays;

public class AssignCookies {
    private int findContentChildren(int[] g, int[] s) {
        int totalChildren = g.length;
        int totalCookies = s.length;

        if (totalChildren == 0 || totalCookies == 0) {
            return 0;
        }
        int satisfiedChildren = 0;
        int greedFactorIndex = 0;
        int cookieSizeIndex = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (greedFactorIndex < totalChildren && cookieSizeIndex < totalCookies) {
            if (g[greedFactorIndex] <= s[cookieSizeIndex]) {
                satisfiedChildren++;
                greedFactorIndex++;
                cookieSizeIndex++;
            } else {
                cookieSizeIndex++;
            }
        }
        return satisfiedChildren;
    }

    public static void main(String[] args) {
        AssignCookies a = new AssignCookies();
        int[] g = { 1, 2 };
        int[] s = { 1, 2, 3 };
        System.out.println(a.findContentChildren(g, s));
    }
}
