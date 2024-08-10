package com.neetcode.roadmap.arraysAndHashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int num : nums) {
            freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
        }
        Comparator<int[]> customComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        };
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(customComparator);
        for (int key : freqCount.keySet()) {
            minHeap.add(new int[] { key, freqCount.get(key) });
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int index = 0;
        while (!minHeap.isEmpty() && k-- > 0) {
            result[index++] = minHeap.poll()[0];
        }
        return result;
    }
}
