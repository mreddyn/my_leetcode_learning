package com.leetcode.medium;

import java.util.HashSet;

public class MaximumNumberOfNumbersToChooseFromRangeOne {
    public int maxCount(int[] banned, int n, int maxSum) {
        int numCount = 0;
        var bannedSet = new HashSet<Integer>();
        for (int i = 0; i < banned.length; i++) {
            if (banned[i] <= n) {
                bannedSet.add(banned[i]);
            }
        }

        int numSum = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            numSum += i;
            if (numSum > maxSum) {
                break;
            }
            numCount++;
        }

        return numCount;
    }
}
