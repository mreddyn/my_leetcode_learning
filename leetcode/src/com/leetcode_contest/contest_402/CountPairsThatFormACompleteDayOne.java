package com.leetcode_contest.contest_402;

import java.util.HashMap;
import java.util.Map;

public class CountPairsThatFormACompleteDayOne {
    public int countCompleteDayPairs(int[] hours) {
        int pairsCount = 0, n = hours.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int pairSum = hours[i] + hours[j];
                if (pairSum % 24 == 0) {
                    pairsCount++;
                }
            }
        }

        return pairsCount;
    }

    public int countCompleteDayPairsApproachTwo(int[] hours) {
        /*
         * since we need to check if hours add up to 24, it becomes Two sum question
         * a+b == 24, we also need to check for multiples of 24
         */
        int pairsCount = 0;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        for (int hour : hours) {
            int remainder = hour % 24;
            if (remainder == 0) {
                pairsCount += remainderMap.getOrDefault(remainder, 0);
            } else {
                // search for pair (24 - a)
                int diff = 24 - remainder;
                pairsCount += remainderMap.getOrDefault(diff, 0);
            }
            remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
        }

        return pairsCount;
    }
}
