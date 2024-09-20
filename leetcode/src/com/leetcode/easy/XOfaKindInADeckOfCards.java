package com.leetcode.easy;

import java.util.HashMap;

public class XOfaKindInADeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        /*
         * count all occurrences of cards.
         * Find the greatest common divisor of frequencies of cards (which decides the
         * min group size)
         * The group size should be greater than 1.
         */
        var cardsMap = new HashMap<Integer, Integer>();
        for (int card : deck) {
            cardsMap.put(card, cardsMap.getOrDefault(card, 0) + 1);
        }

        int res = 0;
        for (int group : cardsMap.values()) {
            res = gcd(group, res);
        }

        return res > 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
