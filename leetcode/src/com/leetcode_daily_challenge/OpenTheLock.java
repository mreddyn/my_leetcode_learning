package com.leetcode_daily_challenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

public class OpenTheLock {
    private int openLock(String[] deadends, String target) {
        int minimumTurns = 0;
        Map<Character, Character> nextSlot = Map.of(
                '0', '1',
                '1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0');
        Map<Character, Character> prevSlot = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8');

        // set to store visited and deadends combinations
        HashSet<String> visitedCombinations = new HashSet<>(Arrays.asList(deadends));

        if (visitedCombinations.contains("0000")) {
            return -1;
        }

        // Queue to store combinations after turning each wheel
        ArrayDeque<String> pendingCombinations = new ArrayDeque<>();

        // starting with "0000"
        pendingCombinations.add("0000");
        visitedCombinations.add("0000");

        while (!pendingCombinations.isEmpty()) {
            int curLevelNodesCount = pendingCombinations.size();
            for (int i = 1; i <= curLevelNodesCount; i++) {
                String currentCombination = pendingCombinations.poll();

                // if current combination matches target then return
                if (currentCombination.equals(target)) {
                    return minimumTurns;
                }

                for (int wheel = 0; wheel < 4; wheel++) {
                    StringBuilder newCombination = new StringBuilder(currentCombination);
                    newCombination.setCharAt(wheel, nextSlot.get(newCombination.charAt(wheel)));

                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString());
                        visitedCombinations.add(newCombination.toString());
                    }

                    newCombination = new StringBuilder(currentCombination);
                    newCombination.setCharAt(wheel, prevSlot.get(newCombination.charAt(wheel)));

                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString());
                        visitedCombinations.add(newCombination.toString());
                    }

                }
            }
            minimumTurns++;
        }

        return -1;
    }

    public static void main(String[] args) {
        OpenTheLock openTheLock = new OpenTheLock();
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        System.out.println(openTheLock.openLock(deadends, target));
    }
}
