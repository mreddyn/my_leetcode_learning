package com.leetcode.hard;

import java.util.PriorityQueue;

public class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        var minHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                minHeap.add(i * j);
                while (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        System.out.println(minHeap);

        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthSmallestNumberInMultiplicationTable kTable = new KthSmallestNumberInMultiplicationTable();
        System.out.println(kTable.findKthNumber(3, 3, 5));
        System.out.println(kTable.findKthNumber(2, 3, 6));
    }
}
