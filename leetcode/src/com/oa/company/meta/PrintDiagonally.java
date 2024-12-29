package com.oa.company.meta;

public class PrintDiagonally {
    public void printMatrixByDifference(int[][] matrix, int diff) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // diff = (col-row)
        // col = diff+row
        var sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            int col = row + diff;
            if (col >= 0 && col < cols) {
                sb.append(matrix[row][col] + " ");
            }

        }

        // only print if not empty
        if (sb.length() > 0) {
            System.out.println(sb.toString().trim());
        }

    }

    public static void main(String[] args) {
        PrintDiagonally pd = new PrintDiagonally();
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int rows = matrix.length;
        int cols = matrix[0].length;
        // we want to print the matrix by difference (col-row)
        // first zero difference, then -1, -2, -3.. minDiff and +1, +2, +3.. maxDiff
        // first print zero difference
        pd.printMatrixByDifference(matrix, 0);

        // then print -1 to minDiff
        int minDiff = -(rows - 1);
        int maxDiff = (cols - 1);

        for (int diff = -1; diff >= minDiff; diff--) {
            pd.printMatrixByDifference(matrix, diff);
        }

        // now 1 to maxDiff
        for (int diff = 1; diff <= maxDiff; diff++) {
            pd.printMatrixByDifference(matrix, diff);
        }
    }
}
