package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayIntoTwoDArray {
    private List<List<Integer>> findMatrix(int[] nums) {
        int[] freqMap = new int[201];
        for (int num : nums) {
            freqMap[num]++;
        }
        int maxFreqElement = 0;
        int maxFreq = 0;
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] > maxFreq) {
                maxFreq = freqMap[i];
                maxFreqElement = i;
            }
        }
        if (maxFreqElement == 0) {
            return null;
        }
        int totalRows = maxFreq;
        int totalCols = 0;
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] > 0) {
                totalCols++;
            }
        }
        int[][] matrix = new int[totalRows][totalCols];
        int row = 0;
        int col = 0;
        for (int i = 0; i < freqMap.length; i++) {
            if (freqMap[i] > 0) {
                for (int j = 0; j < freqMap[i]; j++) {
                    matrix[row][col] = i;
                    row++;
                }
                row = 0;
                col++;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < totalRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < totalCols; j++) {
                if (matrix[i][j] != 0) {
                    rowList.add(matrix[i][j]);
                }
            }
            result.add(rowList);
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertArrayIntoTwoDArray c = new ConvertArrayIntoTwoDArray();
        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        System.out.println(c.findMatrix(nums));
    }
}
