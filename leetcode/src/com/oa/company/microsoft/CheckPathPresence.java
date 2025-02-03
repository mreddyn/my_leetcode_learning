package com.oa.company.microsoft;

public class CheckPathPresence {
    public int checkPathPresence(int N, int[] A, int[] B) {
        /*
         * You are given an undirected graph consisting of N vertices, numbered from 1
         * to N, and M edges. The graph is described by two arrays, A and B, both of
         * length M. A pair (A[K], B[K]) for K from 0 to M-1 describes an edge between
         * vertex A[K] and vertex B[K]. Your task is to check whether the given graph
         * contains a path from vertex 1 to vertex N going through all the vertices one
         * by one in increasing order of their numbers. All connections on the path
         * should be direct.
         */
        boolean[] visited = new boolean[N + 1];
        dfs(1, A, B, visited);
        return visited[N] ? 1 : 0;
    }

    private void dfs(int node, int[] A, int[] B, boolean[] visited) {
        visited[node] = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == node && !visited[B[i]]) {
                dfs(B[i], A, B, visited);
            } else if (B[i] == node && !visited[A[i]]) {
                dfs(A[i], A, B, visited);
            }
        }
    }

    public static void main(String[] args) {
        CheckPathPresence obj = new CheckPathPresence();
        int N = 4;
        int[] A = { 1, 2, 4, 4, 3 };
        int[] B = { 2, 3, 1, 3, 1 };
        System.out.println(obj.checkPathPresence(N, A, B)); // should be 1
    }
}