package com.company.microsoft.leetcode.medium;

import java.util.Arrays;

public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, missingSum = 0, sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }

        missingSum = (mean * (m + n)) - sum;
        if (missingSum > 6 * n || missingSum < n) {
            return new int[0];
        }
        int part = missingSum / n, remainder = missingSum % n;
        var missingElements = new int[n];
        Arrays.fill(missingElements, part);
        for (int i = 0; i < remainder; i++) {
            missingElements[i]++;
        }

        return missingElements;
    }
}
