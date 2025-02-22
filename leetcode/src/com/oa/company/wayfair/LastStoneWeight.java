package com.oa.company.wayfair;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        var max_heap = new PriorityQueue<Integer>((a, b) -> (b - a));
        for (int stone : stones) {
            max_heap.offer(stone);
        }

        while (max_heap.size() > 1) {
            int y = max_heap.poll();
            int x = max_heap.poll();
            if (x == y) {
                continue;
            }
            y -= x;
            max_heap.offer(y);
        }

        if (max_heap.isEmpty()) {
            return 0;
        }
        return max_heap.peek();
    }

    public static void main(String[] args) {
        var instance = new LastStoneWeight();
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(instance.lastStoneWeight(stones)); // Expected output: 1
    }
}
