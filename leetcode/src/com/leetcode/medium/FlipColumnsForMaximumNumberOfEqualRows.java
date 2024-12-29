package com.leetcode.medium;

import java.util.HashMap;

public class FlipColumnsForMaximumNumberOfEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        /*
         * Each row's pattern is determined by grouping contiguous blocks of identical
         * values. For instance:
         * 
         * Row [0, 0, 0, 1, 1, 0, 0] produces the pattern: ***|**|**|
         * Row [0, 1, 1, 1, 1, 1, 0] produces the pattern: *|*****|*|
         * The solution is simply the frequency of the most common pattern across all
         * rows in the matrix.
         */
        int maxEqualRowCount = 0, rows = matrix.length, cols = matrix[0].length;
        // we will maintain a hashmap to count the freq of the pattern <String,Integer>
        var map = new HashMap<String, Integer>();
        for (int row = 0; row < rows; row++) {

            // find pattern for each row.
            // we will check adjacent elements. if same increment count
            // else add count and '|'
            int count = 1;
            var sb = new StringBuilder();
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == matrix[row][col - 1]) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append('|');
                    count = 1;
                }
            }

            sb.append(count);

            // convert sb to string and insert into map
            var pattern = sb.toString();
            map.put(pattern, map.getOrDefault(pattern, 0) + 1);
            maxEqualRowCount = Math.max(maxEqualRowCount, map.get(pattern));
        }

        return maxEqualRowCount;
    }
}
