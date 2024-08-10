package com.company.confluent;

import java.util.*;

// Building the Graph:
// Construct a representation of the DAG from the input parent-child pairs.
// This includes identifying all unique nodes and their relationships.
//
//Finding Root Nodes: Determine the root nodes (nodes with in-degree of 0) as these are starting points for BFS.
//
//Performing BFS and Storing Parents: For each root node, perform Breadth-First Search (BFS) to explore the graph, while storing each node's parents and their depth. This step builds the parents array of vectors you mentioned.
//
//Finding Ancestors of x and y: Utilize the parents array to find all ancestors of nodes x and y, along with their depth.
//
//Identifying the LCA: Compare the ancestors of x and y to find the common ancestor(s) with the greatest depth.


//Test this
// Input:
//1.
//Monsters: Dragons, Zombies, Snakes, Goblins, ...
//Dragons -> Zombies, Goblins,
//Zombies -> Goblins
//Goblins -> Snakes
//2.
//List of monsters(e.g. [snakes, goblins])
//
//Output:
//The least-strong monster that can defeat every monster in the input list([snakes, goblins]). (e.g. i n this case it's zombie, because a dragon is more powerful)
//
//If there are multiple answers, you can return any of them.
// https://www.1point3acres.com/bbs/thread-937990-1-1.html
public class DAGLowestCommonAncestor {

    // Method to find the LCA
    public static Set<String> findLCA(List<String[]> parentChildPairs, List<String> nodes) {
        // Build the graph and the in-degree map
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (String[] pair : parentChildPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            inDegree.put(pair[1], inDegree.getOrDefault(pair[1], 0) + 1);
            inDegree.putIfAbsent(pair[0], 0);
        }

        // Find the roots (nodes with in-degree 0)
        Set<String> roots = new HashSet<>();
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                roots.add(node);
            }
        }

        // BFS to find ancestors and their depths
        Map<String, Integer> depths = new HashMap<>();
        for (String root : roots) {
            bfs(graph, root, depths);
        }

        // Find ancestors for all nodes
        List<Set<String>> allAncestors = new ArrayList<>();
        for (String node : nodes) {
            Set<String> ancestors = findAncestors(graph, node);
            if (ancestors.size() == 0) continue;
            allAncestors.add(ancestors);
        }

        Set<String> commonAncestors = new HashSet<>(allAncestors.get(0)); // Start with the ancestors of the first node
        for (Set<String> ancestors : allAncestors) {
            System.out.println(commonAncestors);
            commonAncestors.retainAll(ancestors); // Intersection
        }

        // Identify the LCA based on the greatest depth
//        String lca = null;
//        int maxDepth = -1;
//        for (String ancestor : commonAncestors) {
//            if (depths.get(ancestor) > maxDepth) {
//                maxDepth = depths.get(ancestor);
//                lca = ancestor;
//            }
//        }
//        return lca;
        return commonAncestors;
    }

    // BFS to compute depths of all nodes
    private static void bfs(Map<String, List<String>> graph, String root, Map<String, Integer> depths) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(root);
        depths.put(root, 0);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDepth = depths.get(current);
            for (String child : graph.getOrDefault(current, Collections.emptyList())) {
                depths.put(child, currentDepth + 1);
                queue.offer(child);
            }
        }
    }

    // Find ancestors of a node
    private static Set<String> findAncestors(Map<String, List<String>> graph, String node) {
        Set<String> ancestors = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Initially, add all direct parents of the node to the queue
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            if (entry.getValue().contains(node)) {
                queue.offer(entry.getKey());
                visited.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            ancestors.add(current);
            // Add parents of the current node to the queue
            for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
                if (entry.getValue().contains(current) && visited.add(entry.getKey())) {
                    queue.offer(entry.getKey());
                }
            }
        }
        return ancestors;
    }


    public static void main(String[] args) {
        List<String[]> parentChildPairs = new ArrayList<>();
        parentChildPairs.add(new String[]{"dragon", "skeleton"});
        parentChildPairs.add(new String[]{"skeleton", "goblin"});
        parentChildPairs.add(new String[]{"skeleton", "ratman"});
        parentChildPairs.add(new String[]{"skeleton", "chimera"});
        parentChildPairs.add(new String[]{"goblin", "demon"});
        parentChildPairs.add(new String[]{"demon", "cerebrus"});
        parentChildPairs.add(new String[]{"goblin", "zombie"});
        parentChildPairs.add(new String[]{"zombie", "rouge"});
        parentChildPairs.add(new String[]{"zombie", "lava blast"});
        parentChildPairs.add(new String[]{"lava blast", "giant snake"});
        parentChildPairs.add(new String[]{"chimera", "ghost"});
        parentChildPairs.add(new String[]{"ghost", "slime"});

        List<String> nodes = Arrays.asList("cerebrus", "lava blast", "giant snake", "dragon");

        System.out.println(findLCA(parentChildPairs, nodes));

    }
}
