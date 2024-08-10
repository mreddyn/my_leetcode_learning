package com.leetcode_daily_challenge;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    private int leastInterval(char[] tasks, int n) {
        int count = 0;
        if (tasks == null || tasks.length == 0) {
            return count;
        }
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char c : tasks) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue()));
        queue.addAll(charFrequencyMap.entrySet());

        while (!queue.isEmpty()) {

            int interval = n + 1;
            List<Map.Entry<Character, Integer>> list = new LinkedList<>();

            while (interval > 0 && !queue.isEmpty()) {
                Map.Entry<Character, Integer> entry = queue.poll();
                entry.setValue(entry.getValue() - 1);
                list.add(entry);
                interval--;
                count++;
            }

            for (Map.Entry<Character, Integer> entry : list) {
                if (entry.getValue() > 0) {
                    queue.offer(entry);
                }
            }

            if (queue.isEmpty()) {
                break;
            }
            count += interval;
        }

        return count;
    }
}
