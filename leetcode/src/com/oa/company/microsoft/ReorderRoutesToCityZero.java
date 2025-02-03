package com.oa.company.microsoft;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ReorderRoutesToCityZero {
    public int minReorder(int n, int[][] connections) {
        /*
         * convert the connections to a undirected graph.
         * store the routes in a HashSet.
         * We will do a breadth First Search starting from root node 0;
         * we will visit the root node children one by one.
         * if a path exists from child to parent (its possible to reach city zero)
         * if a path does not exist from child to parent then we add a route.
         * we will keep a boolean array to keep track of visited children.
         */
        int minRoutesAdded = 0;
        var routes = new HashSet<String>();
        var undirectedGraph = new HashMap<Integer, Set<Integer>>();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            routes.add(from + "," + to);
            undirectedGraph.putIfAbsent(from, new HashSet<>());
            undirectedGraph.putIfAbsent(to, new HashSet<>());
            undirectedGraph.get(from).add(to);
            undirectedGraph.get(to).add(from);
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        var visited = new boolean[n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int child : undirectedGraph.getOrDefault(parent, new HashSet<>())) {
                if (visited[child]) {
                    continue;
                }
                visited[child] = true;
                if (!routes.contains(child + "," + parent)) {
                    minRoutesAdded++;
                }
                queue.offer(child);
            }

        }

        return minRoutesAdded;
    }
}
