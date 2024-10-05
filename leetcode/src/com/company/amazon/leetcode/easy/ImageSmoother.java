package com.company.amazon.leetcode.easy;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length, cols = img[0].length;
        var imageAfterSmoother = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                imageAfterSmoother[row][col] = getAvg(row, col, rows, cols, img[row][col], img);
            }
        }

        return imageAfterSmoother;
    }

    private int getAvg(int row, int col, int rows, int cols, int val, int[][] img) {
        int sum = val, n = 1;
        if (row - 1 >= 0 && col - 1 >= 0) {
            sum += img[row - 1][col - 1];
            n++;
        }
        if (row - 1 >= 0 && col + 1 < cols) {
            sum += img[row - 1][col + 1];
            n++;
        }
        if (row + 1 < rows && col - 1 >= 0) {
            sum += img[row + 1][col - 1];
            n++;
        }
        if (row + 1 < rows && col + 1 < cols) {
            sum += img[row + 1][col + 1];
            n++;
        }
        if (row - 1 >= 0) {
            sum += img[row - 1][col];
            n++;
        }
        if (row + 1 < rows) {
            sum += img[row + 1][col];
            n++;
        }
        if (col - 1 >= 0) {
            sum += img[row][col - 1];
            n++;
        }
        if (col + 1 < cols) {
            sum += img[row][col + 1];
            n++;
        }
        return sum / n;
    }
}
