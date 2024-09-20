package com.leetcode.easy;

import java.util.HashMap;

public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        /*
         * if the numbers of pairs is 3, then we can form 3 equal pairs.
         * if the numbers of pairs is 4, then we can form 6 equal pairs.
         * So the formula is N * (N-1)/2
         * 
         * To simplify the dominoes we can convert them each pairs into single number.
         * d[0,1] = Math.min(d[0], d[1])*10 + Math.max(d[0], d[1]).
         * After converting we can count how many times each pair is present and use
         * the formula.
         */
        int pairsCount = 0, n = dominoes.length;
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int smallNum = Math.min(dominoes[i][0], dominoes[i][1]);
            int largeNum = Math.max(dominoes[i][0], dominoes[i][1]);
            int transformed = smallNum * 10 + largeNum;
            map.put(transformed, map.getOrDefault(transformed, 0) + 1);
        }

        for (int value : map.values()) {
            pairsCount += (value * (value - 1)) / 2;
        }

        return pairsCount;
    }
}
