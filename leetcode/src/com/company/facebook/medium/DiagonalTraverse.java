package com.company.facebook.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        /*
         * The key here is to realize that the sum of indices on all diagonals are
         * equal.
         * For example, in
         * 
         * [1,2,3]
         * [4,5,6]
         * [7,8,9]
         * 2, 4 are on the same diagonal, and they share the index sum of 1. (2 is
         * matrix[0][1] and 4 is in matrix[1][0]). 3,5,7 are on the same diagonal, and
         * they share the sum of 2. (3 is matrix[0][2], 5 is matrix[1][1], and 7 is
         * matrix [2][0]).
         * 
         * SO, if you can loop through the matrix, store each element by the sum of its
         * indices in a dictionary, you have a collection of all elements on shared
         * diagonals.
         */
        int rows = mat.length, cols = mat[0].length;
        var result = new int[rows * cols];
        var map = new HashMap<Integer, List<Integer>>();
        int maxIndexSum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                map.computeIfAbsent(row + col, x -> new ArrayList<>()).add(mat[row][col]);
                maxIndexSum = Math.max(row + col, maxIndexSum);
            }
        }

        int index = 0;
        for (int i = 0; i <= maxIndexSum; i++) {
            var temp = map.get(i);
            if (i % 2 == 0) {
                Collections.reverse(temp);
            }

            for (int num : temp) {
                result[index++] = num;
            }
        }

        return result;
    }
}
