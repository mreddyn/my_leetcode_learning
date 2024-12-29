package com.company.facebook.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        var graph = new HashMap<String, Set<String>>(); // email node -> neighbor nodes
        var name = new HashMap<String, String>(); // email, username

        // Build the graph
        for (var account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                graph.putIfAbsent(account.get(i), new HashSet<>());
                name.put(account.get(i), userName);

                if (i == 1) {
                    continue;
                }

                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        var visited = new HashSet<String>();
        List<List<String>> res = new ArrayList<>();

        // DFS search the graph
        for (String email : name.keySet()) {
            var list = new ArrayList<String>();
            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }

        return res;
    }

    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }

    }
}
