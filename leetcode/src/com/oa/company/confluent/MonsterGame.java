package com.oa.company.confluent;

import java.util.*;

public class MonsterGame {

    // Helper method to perform DFS and fill the reachability set with memoization
    private static Set<String> dfs(String monster, Map<String, List<String>> graph, Map<String, Set<String>> memo) {
        if (memo.containsKey(monster)) {
            return memo.get(monster);
        }

        Set<String> reachable = new HashSet<>();
        reachable.add(monster);

        if (graph.containsKey(monster)) {
            for (String neighbor : graph.get(monster)) {
                reachable.addAll(dfs(neighbor, graph, memo));
            }
        }

        memo.put(monster, reachable);
        return reachable;
    }

    // Method to check if a monster can reach all hostile monsters
    private static boolean canDefeatAll(String monster, Set<String> hostileMonsters, Map<String, Set<String>> memo) {
        Set<String> reachables = memo.getOrDefault(monster, Collections.emptySet());
        return reachables.containsAll(hostileMonsters);
    }

    public static Set<String> findMonstersThatCanDefeatAll(String[][] monsters, Set<String> hostileMonsters) {
        // Step 1: Build the defeat map
        Map<String, List<String>> graph = new HashMap<>();
        for (String[] pair : monsters) {
            String winner = pair[0];
            String loser = pair[1];
            graph.computeIfAbsent(winner, k -> new ArrayList<>()).add(loser);
        }

        // Step 2: Find all monsters
        Set<String> allMonsters = new HashSet<>();
        for (String[] pair : monsters) {
            allMonsters.add(pair[0]);
            allMonsters.add(pair[1]);
        }

        // Step 3: Compute reachability for each monster using memoization
        Map<String, Set<String>> memo = new HashMap<>();
        for (String monster : allMonsters) {
            dfs(monster, graph, memo);
        }

        // Step 4: Check which monsters can defeat all hostile monsters
        Set<String> result = new HashSet<>();
        for (String monster : allMonsters) {
            if (canDefeatAll(monster, hostileMonsters, memo)) {
                result.add(monster);
            }
        }

        // Step 5: Remove Hostile monsters which are present in the result list
        for (String hostileMonster : hostileMonsters) {
            if (result.contains(hostileMonster)) {
                result.remove(hostileMonster);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[][] monsters = {
                { "Dragon", "Skeleton" },
                { "Skeleton", "Goblin" },
                { "Skeleton", "Chimera" },
                { "Skeleton", "Ratman" },
                { "Goblin", "Demon" },
                { "Demon", "Cerebus" },
                { "Goblin", "Zombie" },
                { "Zombie", "Rogue" },
                { "Zombie", "Lava Beast" },
                { "Lava Beast", "Giant Snake" },
                { "Chimera", "Ghost" },
                { "Ghost", "Slime" }
        };

        Set<String> hostileMonsters = new HashSet<>(Arrays.asList("Lava Beast", "Giant Snake"));
        Set<String> result = findMonstersThatCanDefeatAll(monsters, hostileMonsters);

        System.out.println(result); // Output should be [Skeleton, Dragon]
    }
}