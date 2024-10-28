package com.leetcode.medium;

public class MinimumCostHomeComingRobotInGrid {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        /*
         * We have 0 <= rowCosts[r], colCosts[c] <= 10^4,
         * that means we don't go duplicated path.
         * 
         * From the view of row index, the best path will be go directly from start x to
         * home x
         * From the view of col index, the best path will be go directly from start y to
         * home y
         * 
         * Explanation
         * Firstly move rows, from startPos[0] to homePos[0].
         * Secondly move cols, from startPos[1] to homePos[1].
         * Sum up the cost for every step.
         */
        int minimumCost = 0;
        if (startPos[0] == homePos[0] && startPos[1] == homePos[1]) {
            return minimumCost;
        }

        while (startPos[0] != homePos[0]) {
            minimumCost += (startPos[0] < homePos[0]) ? rowCosts[++startPos[0]] : rowCosts[--startPos[0]];
        }

        while (startPos[1] != homePos[1]) {
            minimumCost += (startPos[1] < homePos[1]) ? colCosts[++startPos[1]] : colCosts[--startPos[1]];
        }

        return minimumCost;
    }
}
