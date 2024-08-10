package com.leetcode.easy;

import java.util.HashSet;

public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int missingNumber = 0, repeatedNumber = 0, rows = grid.length, cols = grid[0].length;
        HashSet<Integer> numSet = new HashSet<>();
        int sumOfFirstNNumbers = 0, sumOfFirstNNumbersWithOneMissingNumber = 0, n = rows * rows;
        sumOfFirstNNumbers = (n * (n + 1)) / 2;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int num = grid[row][col];
                if (numSet.contains(num)) {
                    repeatedNumber = num;
                    continue;
                }
                numSet.add(num);
                sumOfFirstNNumbersWithOneMissingNumber += num;
            }
        }
        missingNumber = sumOfFirstNNumbers - sumOfFirstNNumbersWithOneMissingNumber;

        int[] answer = new int[] { repeatedNumber, missingNumber };
        return answer;
    }
}
