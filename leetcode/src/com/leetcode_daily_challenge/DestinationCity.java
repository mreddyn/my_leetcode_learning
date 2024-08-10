package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    private String destCity(List<List<String>> paths) {
        Map<String, List<String>> graph = new HashMap<>();
        int totalEdges = paths.size();
        for (int edge = 0; edge < totalEdges; edge++) {
            List<String> path = paths.get(edge);
            String src = path.get(0);
            String dest = path.get(1);
            if (!graph.containsKey(src)) {
                graph.put(src, new ArrayList<>());
            }
            graph.get(src).add(dest);
        }

        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!graph.containsKey(dest)) {
                return dest;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        DestinationCity dc = new DestinationCity();
        List<List<String>> paths = new ArrayList<>();
        paths.add(List.of("London", "New York"));
        paths.add(List.of("New York", "Lima"));
        paths.add(List.of("Lima", "Sao Paulo"));
        System.out.println(dc.destCity(paths));
    }
}
