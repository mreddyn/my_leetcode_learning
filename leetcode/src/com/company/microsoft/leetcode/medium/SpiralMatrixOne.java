package com.company.microsoft.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixOne {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        int rowBegin = 0, rowEnd = matrix.length - 1, colBegin = 0, colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse right
            for (int col = colBegin; col <= colEnd; col++) {
                spiralList.add(matrix[rowBegin][col]);
            }
            rowBegin++;
            // traverse down
            for (int row = rowBegin; row <= rowEnd; row++) {
                spiralList.add(matrix[row][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // traverse left
                for (int col = colEnd; col >= colBegin; col--) {
                    spiralList.add(matrix[rowEnd][col]);
                }
                rowEnd--;
            }
            if (colBegin <= colEnd) {
                // traverse up
                for (int row = rowEnd; row >= rowBegin; row--) {
                    spiralList.add(matrix[row][colBegin]);
                }
                colBegin++;
            }

        }
        return spiralList;
    }
}
