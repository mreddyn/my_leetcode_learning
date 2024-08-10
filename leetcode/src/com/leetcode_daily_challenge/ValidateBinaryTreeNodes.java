package com.leetcode_daily_challenge;

public class ValidateBinaryTreeNodes {
    private boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        for (int index = 0; index < n; index++) {
            if (leftChild[index] != -1) {
                inDegree[leftChild[index]]++;
            }
            if (rightChild[index] != -1) {
                inDegree[rightChild[index]]++;
            }
        }
        for (int index = 0; index < n; index++) {
            if (inDegree[index] > 1) {
                return false;
            }
        }
        int rootCount = 0;
        for (int index = 0; index < n; index++) {
            if (inDegree[index] == 0) {
                rootCount++;
            }
        }
        if (rootCount != 1) {
            return false;
        }
        boolean visited[] = new boolean[n];
        return dfs(0, leftChild, rightChild, visited);
    }

    private boolean dfs(int index, int[] leftChild, int[] rightChild, boolean[] visited) {
        if (index == -1) {
            return true;
        }
        if (visited[index]) {
            return false;
        }
        visited[index] = true;
        return dfs(leftChild[index], leftChild, rightChild, visited)
                && dfs(rightChild[index], leftChild, rightChild, visited);
    }

    public static void main(String[] args) {
        ValidateBinaryTreeNodes validateBinaryTreeNodes = new ValidateBinaryTreeNodes();
        int n = 4;
        int[] leftChild = { 1, -1, 3, -1 };
        int[] rightChild = { 2, -1, -1, -1 };
        System.out.println(validateBinaryTreeNodes.validateBinaryTreeNodes(n, leftChild, rightChild));
    }
}
