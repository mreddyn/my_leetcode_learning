package com.leetcode;

public class CountPairsThatFormACompleteDayTwo {
    public long countCompleteDayPairsBruteForce(int[] hours) {
        int n = hours.length, pairsCount = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    pairsCount++;
                }
            }
        }
        return pairsCount;
    }

    public long countCompleteDayPairs(int[] hours) {
        int n = hours.length;
        long pairsCount = 0;
        long[] remainderFreqCount = new long[24];
        for (int i = 0; i < n; i++) {
            int remainder = hours[i] % 24;
            remainderFreqCount[remainder]++;
        }
        // hours which are multiples of 24
        long zerosCount = remainderFreqCount[0];
        pairsCount += (zerosCount * (zerosCount - 1)) / 2;

        // now hours which add up to 24
        for (int i = 1; i < 12; i++) {
            pairsCount += remainderFreqCount[i] * remainderFreqCount[24 - i];
        }

        // for when hour = 12
        pairsCount += (remainderFreqCount[12] * (remainderFreqCount[12] - 1)) / 2;
        return pairsCount;
    }
}
