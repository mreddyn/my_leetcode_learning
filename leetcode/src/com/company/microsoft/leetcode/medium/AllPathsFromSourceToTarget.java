package com.company.microsoft.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    private List<List<Integer>> paths;
    private int target;
    private int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList<>();
        target = graph.length - 1;
        this.graph = graph;
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        backtrack(0, path);
        return this.paths;
    }

    private void backtrack(int curNode, LinkedList<Integer> path) {
        if (curNode == target) {
            paths.add(new ArrayList<>(path));
            return;
        }
        // explore the neighbor nodes one after the other
        for (int nextNode : this.graph[curNode]) {
            // visit the next neighbor
            path.addLast(nextNode);
            backtrack(nextNode, path);
            // remove the current added neighbor to traverse through next path
            path.removeLast();
        }
    }
}
