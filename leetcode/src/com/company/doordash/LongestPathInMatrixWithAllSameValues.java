package com.company.doordash;

public class LongestPathInMatrixWithAllSameValues {
    int longestPath = 0;

    public int getLongestPath(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                dfs(arr, visited, row, col, arr[row][col], 0);
            }
        }

        return longestPath;
    }

    private void dfs(int[][] arr, boolean[][] visited, int row, int col, int target, int path) {
        if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || visited[row][col]
                || arr[row][col] != target) {
            longestPath = Math.max(path, longestPath);
            return;
        }

        if (arr[row][col] == target) {
            path++;
        }

        visited[row][col] = true;
        dfs(arr, visited, row + 1, col, target, path);
        dfs(arr, visited, row, col + 1, target, path);
        dfs(arr, visited, row - 1, col, target, path);
        dfs(arr, visited, row, col - 1, target, path);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        LongestPathInMatrixWithAllSameValues longestPathInMatrixWithAllSameValues = new LongestPathInMatrixWithAllSameValues();
        int[][] arr = { { 1, 2, 3, 4 }, { 1, 1, 1, 4 }, { 1, 2, 3, 4 } };
        System.out.println(longestPathInMatrixWithAllSameValues.getLongestPath(arr)); // 4
    }
}
