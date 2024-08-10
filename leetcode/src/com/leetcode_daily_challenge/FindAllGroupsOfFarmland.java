package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class FindAllGroupsOfFarmland {
    int row2, col2;

    private int[][] findFarmland(int[][] land) {
        int rows = land.length, cols = land[0].length;
        List<int[]> resultList = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (land[row][col] == 1) {
                    row2 = 0;
                    col2 = 0;
                    dfs(land, row, col, rows, cols);
                    int[] arr = new int[] { row, col, row2, col2 };
                    resultList.add(arr);
                }
            }
        }
        return resultList.stream().toArray(int[][]::new);
    }

    private void dfs(int[][] land, int row, int col, int rows, int cols) {
        land[row][col] = 0;
        row2 = Math.max(row2, row);
        col2 = Math.max(col2, col);
        if (row + 1 < rows && land[row + 1][col] == 1) {
            dfs(land, row + 1, col, rows, cols);
        }
        if (col + 1 < cols && land[row][col + 1] == 1) {
            dfs(land, row, col + 1, rows, cols);
        }
    }

    public static void main(String[] args) {
        FindAllGroupsOfFarmland findAllGroupsOfFarmland = new FindAllGroupsOfFarmland();
        findAllGroupsOfFarmland.findFarmland(null);
    }
}
