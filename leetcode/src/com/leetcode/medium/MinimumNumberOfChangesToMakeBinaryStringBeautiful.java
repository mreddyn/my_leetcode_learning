package com.leetcode.medium;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    public int minChanges(String s) {
        int n = s.length(), changeCount = 0;
        for (int i = 0; i < n; i += 2) {
            int zeros = 0, ones = 0;
            for (int j = i; j < i + 2; j++) {
                if (s.charAt(j) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            changeCount += 2 - Math.max(ones, zeros);
        }

        return changeCount;
    }

    public int minChangesApproachTwo(String s) {
        int n = s.length(), changeCount = 0;
        for (int i = 0; i < n - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changeCount++;
            }
        }

        return changeCount;
    }

    public static void main(String[] args) {
        MinimumNumberOfChangesToMakeBinaryStringBeautiful mBeautiful = new MinimumNumberOfChangesToMakeBinaryStringBeautiful();
        System.out.println(mBeautiful.minChanges("1001"));
    }
}
