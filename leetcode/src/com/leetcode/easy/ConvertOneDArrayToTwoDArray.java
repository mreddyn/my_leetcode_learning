package com.leetcode.easy;

public class ConvertOneDArrayToTwoDArray {
    public int[][] convert(int[] nums, int rows, int cols) {
        int n = nums.length;
        var matrix = new int[rows][cols];
        /*
         * 1,2,3,4,5,6 , rows = 3, cols = 2 =>
         * 1,4 00 10
         * 2,5 10 11
         * 3,6 20 21
         */
        for (int i = 0; i < n; i++) {
            matrix[i % rows][i / rows] = nums[i];
        }

        return matrix;
    }

    public static void main(String[] args) {
        ConvertOneDArrayToTwoDArray cArray = new ConvertOneDArrayToTwoDArray();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int rows = 4, cols = 2;
        var matrix = cArray.convert(nums, rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
