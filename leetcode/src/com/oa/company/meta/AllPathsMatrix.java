package com.oa.company.meta;

import java.util.ArrayList;
import java.util.List;

public class AllPathsMatrix {
    public void printAllPaths(int[][] matrix) {
        var path = new ArrayList<Integer>();
        backtrack(matrix, 0, 0, path);
    }

    private void backtrack(int[][] matrix, int row, int col, List<Integer> path) {
        int rows = matrix.length, cols = matrix[0].length;
        // add current cell to path
        path.add(matrix[row][col]);
        if (row == rows - 1 && col == cols - 1) {
            // we reached bottom-right so print
            System.out.println(path);
        } else {
            // we have two options
            // option 1: move right
            if (col + 1 < cols) {
                backtrack(matrix, row, col + 1, path);
            }

            // option 2: move down
            if (row + 1 < rows) {
                backtrack(matrix, row + 1, col, path);
            }

        }

        // now remove last element that was added
        int lastIndex = path.size() - 1;
        path.remove(lastIndex);

    }

    public static void main(String[] args) {
        AllPathsMatrix aMatrix = new AllPathsMatrix();
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        aMatrix.printAllPaths(matrix);

    }
}
