package com.company.doordash;

public class DoorDashDriverCoverage {
    public int clusterCount(int[][] driversAvailable, int[][] driversNeeded) {
        int m = driversAvailable.length;
        int n = driversAvailable[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (driversAvailable[i][j] == 0) {
                    dfs(i, j, driversNeeded, m, n);
                }
            }
        }

        // count clusters
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (driversNeeded[i][j] == 1) {
                    count++;
                    dfs(i, j, driversNeeded, m, n);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, int[][] grid, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(i + 1, j, grid, m, n);
        dfs(i - 1, j, grid, m, n);
        dfs(i, j + 1, grid, m, n);
        dfs(i, j - 1, grid, m, n);
    }

    public static void main(String[] args) {
        DoorDashDriverCoverage d = new DoorDashDriverCoverage();
        int[][] driverAvailableLocations = {
                { 1, 1, 1, 0, 0 },
                { 0, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 1 }
        };

        int[][] driversNeededAt = {
                { 1, 1, 1, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 1, 0, 0, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 }
        };

        System.out.println(d.clusterCount(driverAvailableLocations, driversNeededAt));
    }
}
