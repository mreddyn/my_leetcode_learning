package com.company.amazon.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // map to store oldNode, and newNode relationship
        var visited = new HashMap<Node, Node>();

        // queue for BFS traversal
        var queue = new ArrayDeque<Node>();
        queue.offer(node);

        // clone the node and put into map
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            // Iterate through the neighbors of n
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // if neighbor is not visited then clone it and put it map
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));

                    // add the newly neighbor to queue
                    queue.offer(neighbor);
                }

                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
