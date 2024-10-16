package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        var spiralList = new ArrayList<Integer>();
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse right (row stays same, column changes)
            for (int col = colBegin; col <= colEnd; col++) {
                spiralList.add(matrix[rowBegin][col]);
            }
            // first row is done, so increment rowBegin
            rowBegin++;

            // traverse down (row changes, column stays same)
            for (int row = rowBegin; row <= rowEnd; row++) {
                spiralList.add(matrix[row][colEnd]);
            }
            // last column is done, so decrement colEnd
            colEnd--;

            // traverse left
            if (rowBegin <= rowEnd) {
                for (int col = colEnd; col >= colBegin; col--) {
                    spiralList.add(matrix[rowEnd][col]);
                }
                rowEnd--;
            }

            // traverse up
            if (colBegin <= colEnd) {
                for (int row = rowEnd; row >= rowBegin; row--) {
                    spiralList.add(matrix[row][colBegin]);
                }

                colBegin++;
            }

        }

        return spiralList;
    }
}
