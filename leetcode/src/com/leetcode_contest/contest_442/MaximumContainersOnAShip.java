package com.leetcode_contest.contest_442;

public class MaximumContainersOnAShip {
    public int maxContainers(int n, int w, int maxWeight) {
        int total_cells = n * n;
        int allowed_containers = maxWeight / w;

        if (total_cells <= allowed_containers) {
            return total_cells;
        } else {
            return allowed_containers;
        }
    }
}
