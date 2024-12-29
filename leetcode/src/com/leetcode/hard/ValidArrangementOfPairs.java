package com.leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ValidArrangementOfPairs {
    public int[][] validArrangement(int[][] pairs) {
        /*
         * for finding start node in a Eulerian path we look for node which has more
         * outgoing edges than incoming edges.
         * 
         * Particularly for the starting node the outgoing edges = 1+incoming edges
         * for regular nodes outgoing edges == incoming edges
         * and for ending node the incoming edges > outgoing edges
         */

        var adjacencyMatrix = new HashMap<Integer, ArrayDeque<Integer>>();
        var inDegree = new HashMap<Integer, Integer>();
        var outDegree = new HashMap<Integer, Integer>();

        // build adjacencyList and in-degree, out-degree
        for (var pair : pairs) {
            int start = pair[0];
            int end = pair[1];

            adjacencyMatrix.computeIfAbsent(start, k -> new ArrayDeque<>()).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        var result = new ArrayList<Integer>();

        // find the start node where outDegree = inDegree+1
        int startNode = -1;
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }

        // if no start node exists then start from pair's first element
        if (startNode == -1) {
            startNode = pairs[0][0];
        }

        // start DFS traversal
        visit(startNode, adjacencyMatrix, result);

        // reverse the List
        Collections.reverse(result);

        // construct result pairs
        var pairedResult = new int[result.size() - 1][2];
        for (int i = 1; i < result.size(); i++) {
            pairedResult[i - 1] = new int[] { result.get(i - 1), result.get(i) };
        }

        return pairedResult;

    }

    private void visit(int node, HashMap<Integer, ArrayDeque<Integer>> adjMatrix, List<Integer> res) {
        var neighbors = adjMatrix.get(node);
        while (neighbors != null && !neighbors.isEmpty()) {
            int nextNode = neighbors.pollFirst();
            visit(nextNode, adjMatrix, res);
        }
        res.add(node);
    }
}
