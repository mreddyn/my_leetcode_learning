package com.oa.company.amazon.second_time;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FindMaxHealthSum {
    public long findMaxHealthSum(int[] health, int[] serverType, int m) {
        long maxHealth = 0;
        int n = health.length;
        var map = new HashMap<Integer, Long>();

        for (int i = 0; i < n; i++) {
            int type = serverType[i];
            long currentHealth = health[i];
            map.put(type, map.getOrDefault(type, 0L) + currentHealth);
        }

        var minHeap = new PriorityQueue<Long>();
        for (long value : map.values()) {
            minHeap.offer(value);

            if (minHeap.size() > m) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            maxHealth += minHeap.poll();
        }

        return maxHealth;
    }

    public static void main(String[] args) {
        FindMaxHealthSum obj = new FindMaxHealthSum();
        System.out.println(obj.findMaxHealthSum(new int[] { 4, 5, 5, 6 }, new int[] { 1, 2, 1, 2 }, 1));
    }
}
