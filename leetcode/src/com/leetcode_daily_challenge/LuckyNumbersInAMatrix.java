package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbersList = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length, minElementInRow, maxElementInCol;
        HashSet<Integer> minNumsInRows = new HashSet<>();
        HashSet<Integer> maxNumsInCols = new HashSet<>();

        // calculate min element for each row
        for (int row = 0; row < rows; row++) {
            minElementInRow = Integer.MAX_VALUE;
            for (int col = 0; col < cols; col++) {
                minElementInRow = Math.min(matrix[row][col], minElementInRow);
            }
            minNumsInRows.add(minElementInRow);
        }

        // calculate max element for each column
        for (int col = 0; col < cols; col++) {
            maxElementInCol = Integer.MIN_VALUE;
            for (int row = 0; row < rows; row++) {
                maxElementInCol = Math.max(maxElementInCol, matrix[row][col]);
            }
            maxNumsInCols.add(maxElementInCol);
        }

        // Now search for common elements in two sets
        for (int minElement : minNumsInRows) {
            if (maxNumsInCols.contains(minElement)) {
                luckyNumbersList.add(minElement);
            }
        }
        return luckyNumbersList;
    }
}
