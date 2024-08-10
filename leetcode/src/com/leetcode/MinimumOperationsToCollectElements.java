package com.leetcode;

import java.util.List;

public class MinimumOperationsToCollectElements {
    private int minOperations(List<Integer> nums, int k) {
        int operationsCount = 0;
        boolean[] visited = new boolean[k + 1];
        int visitedCount = 0;
        for (int index = nums.size() - 1; index >= 0; index--) {
            operationsCount++;
            if (nums.get(index) <= k) {
                if (!visited[nums.get(index)]) {
                    visited[nums.get(index)] = true;
                    visitedCount++;
                }
                if (visitedCount == k) {
                    break;
                }
            }
        }
        return operationsCount;
    }

    public static void main(String[] args) {
        MinimumOperationsToCollectElements minimumOperationsToCollectElements = new MinimumOperationsToCollectElements();
        List<Integer> nums = List.of(3, 2, 5, 3, 1);
        int k = 3;
        int result = minimumOperationsToCollectElements.minOperations(nums, k);
        System.out.println(result);
    }
}
