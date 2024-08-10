package com.oa.company.confluent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MonsterKiller {
    private List<String> monsterKiller(String[][] monsters, Set<String> hostileMonsters) {
        List<String> monsterHunters = new ArrayList<>();
        Map<String, Set<String>> monsterMap = new HashMap<>();
        for (String[] monster : monsters) {
            String killer = monster[0];
            String victim = monster[1];
            if (!monsterMap.containsKey(killer)) {
                monsterMap.put(killer, new HashSet<>());
            }
            Set<String> killerVictims = monsterMap.get(killer);
            killerVictims.add(victim);
            monsterMap.put(killer, killerVictims);

            // if killer exists in one of the monsterMap victims, then
            // we need to add all of killer victims to the monsterMap victims too

            for (String killerKey : monsterMap.keySet()) {
                Set<String> killerKeyVictims = monsterMap.get(killerKey);
                if (killerKeyVictims.contains(killer)) {
                    killerKeyVictims.addAll(killerVictims);
                }
            }
        }
        System.out.println(monsterMap);

        // now iterate through the monsterMap victims and search if all hostileMonsters
        // exists
        for (String killer : monsterMap.keySet()) {
            Set<String> killerVictims = monsterMap.get(killer);
            boolean canKillAllHostileMonsters = true;
            for (String hostileMonster : hostileMonsters) {
                if (killerVictims.contains(hostileMonster)) {
                    continue;
                } else {
                    canKillAllHostileMonsters = false;
                    break;
                }
            }

            if (canKillAllHostileMonsters) {
                monsterHunters.add(killer);
            }
        }
        return monsterHunters;
    }

    public static void main(String[] args) {
        MonsterKiller monsterKiller = new MonsterKiller();
        String[][] monsters = new String[][] {
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
                { "Ghost", "Slime" } };
        Set<String> hostileMonsters = new HashSet<>(Arrays.asList("Ghost", "Lava Beast"));
        System.out.println(monsterKiller.monsterKiller(monsters, hostileMonsters));
    }
}
