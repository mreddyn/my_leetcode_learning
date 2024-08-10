package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    private int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int key : frequencyMap.keySet()) {
            minHeap.add(new int[] { key, frequencyMap.get(key) });
        }
        while (k > 0) {
            int[] top = minHeap.poll();
            if (top[1] > 1) {
                top[1]--;
                minHeap.add(top);
            }
            k--;
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemovals solution = new LeastNumberOfUniqueIntegersAfterKRemovals();
        System.out.println(solution.findLeastNumOfUniqueInts(new int[] { 4, 3, 1, 1, 3, 3, 2 }, 3));
    }
}
