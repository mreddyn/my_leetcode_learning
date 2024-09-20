package com.leetcode.medium;

import java.util.Arrays;

public class MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        var stones = new int[] { a, b, c };
        Arrays.sort(stones);
        if (isArraySorted(stones)) {
            // if all stones are already next to each other, then min and max moves is 0
            return new int[] { 0, 0 };
        }
        int minMoves = 0, maxMoves = stones[2] - stones[0] - 2;
        if (stones[0] + 1 == stones[1] || stones[1] + 1 == stones[2]) {
            // if stones are next to each other then minMoves is 1
            minMoves = 1;
        } else if (stones[0] + 2 == stones[1] || stones[1] + 2 == stones[2]) {
            // if there is only one space between the two stones then minMoves is 1
            minMoves = 1;
        } else {
            minMoves = 2;
        }

        return new int[] { minMoves, maxMoves };
    }

    private boolean isArraySorted(int[] stones) {
        int n = stones.length;
        for (int i = 1; i < n; i++) {
            if (stones[i] != stones[i - 1] + 1) {
                return false;
            }
        }
        return true;
    }
}
