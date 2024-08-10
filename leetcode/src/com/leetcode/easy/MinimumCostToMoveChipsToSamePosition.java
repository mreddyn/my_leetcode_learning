package com.leetcode.easy;

public class MinimumCostToMoveChipsToSamePosition {
    public int minCostToMoveChips(int[] position) {
        /*
         * Since moving chips from even location to another location is zero, we will move
         * all chips from even locations to zero Index and count them. Same for odd location.
         * Finally we return smallest of both.
         */
        int minCost = Integer.MAX_VALUE, totalChipsAtEvenLocation = 0, totalChipsAtOddLocation = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                totalChipsAtEvenLocation++;
            } else {
                totalChipsAtOddLocation++;
            }
        }

        minCost = Math.min(totalChipsAtEvenLocation, totalChipsAtOddLocation);

        return minCost;
    }
}
