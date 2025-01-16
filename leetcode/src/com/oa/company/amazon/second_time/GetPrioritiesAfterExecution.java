package com.oa.company.amazon.second_time;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class GetPrioritiesAfterExecution {
    public int[] getPrioritiesAfterExecution(int[] priority) {
        int n = priority.length;
        var indexMap = new HashMap<Integer, Integer>();
        var reverseMap = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            indexMap.put(i, priority[i]);
            reverseMap.computeIfAbsent(priority[i], k -> new ArrayList<>()).add(i);
        }

        while (true) {
            var currentPriority = reverseMap.firstKey();

            if (currentPriority == 0) {
                break;
            }
            var indices = reverseMap.get(currentPriority);

            if (indices.size() < 2) {
                reverseMap.remove(currentPriority);
                if (reverseMap.isEmpty()) {
                    break;
                }
                continue;
            }

            var iterator = indices.iterator();
            int firstIndex = iterator.next();
            iterator.remove();
            int secondIndex = iterator.next();
            iterator.remove();

            if (indices.isEmpty()) {
                reverseMap.remove(currentPriority);
            }

            indexMap.remove(firstIndex);
            int newPriority = currentPriority / 2;
            indexMap.put(secondIndex, newPriority);
            reverseMap.computeIfAbsent(newPriority, k -> new ArrayList<>()).add(secondIndex);
        }

        return indexMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .mapToInt(Map.Entry::getValue)
                .toArray();
    }

    public int[] getPrioritiesAfterExecutionApproachTwo(int[] priority) {
        int n = priority.length;

        // Final priority array; if an index is "removed", we can mark it as -1 or
        // similar
        int[] finalPriority = new int[n];
        System.arraycopy(priority, 0, finalPriority, 0, n);

        // Frequency map: priority -> how many processes currently have that priority
        Map<Integer, Integer> freq = new HashMap<>();

        // Priority-to-indices map: for each priority, store a queue (lowest index at
        // the front)
        Map<Integer, Deque<Integer>> prioToIndices = new HashMap<>();

        // Populate these maps
        for (int i = 0; i < n; i++) {
            int p = priority[i];
            freq.put(p, freq.getOrDefault(p, 0) + 1);

            prioToIndices
                    .computeIfAbsent(p, key -> new LinkedList<>())
                    .addLast(i);
        }

        // A max-heap of priorities (largest priority at the top)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // Insert all distinct priorities
        for (Integer p : freq.keySet()) {
            maxHeap.offer(p);
        }

        // To mark “removed” indices if you want to skip them in the end
        boolean[] removed = new boolean[n];

        // The main loop
        while (!maxHeap.isEmpty()) {
            int p = maxHeap.peek(); // Look at the top priority

            // If this priority is 0 or doesn't have enough processes, remove it and
            // continue
            if (p == 0 || freq.getOrDefault(p, 0) < 2) {
                maxHeap.poll(); // remove it from heap
                continue;
            }

            // If we get here, freq[p] >= 2 and p != 0
            // Remove two indices with this priority (lowest first)
            Deque<Integer> queue = prioToIndices.get(p);

            if (queue.size() < 2) {
                // Might happen if freq is out of sync, but typically size() should match freq
                maxHeap.poll();
                continue;
            }

            // Get two indices
            int idx1 = queue.removeFirst(); // process to remove
            int idx2 = queue.removeFirst(); // process to be downgraded

            // Mark idx1 as removed
            removed[idx1] = true;
            freq.put(p, freq.get(p) - 2); // we used up two processes of this priority

            // Downgrade second process
            int newP = p / 2;
            finalPriority[idx2] = newP; // update final priority
            freq.put(newP, freq.getOrDefault(newP, 0) + 1);

            // Add idx2 to the queue for newP
            prioToIndices
                    .computeIfAbsent(newP, key -> new LinkedList<>())
                    .addLast(idx2);

            // Clean up the old priority p if needed
            if (freq.get(p) == 0) {
                freq.remove(p);
                prioToIndices.remove(p);
                maxHeap.poll(); // remove p from the heap top
            } else {
                // We used 2 processes of priority p, but there may still be some left
                // Reinsert if we haven't removed it yet
                maxHeap.poll(); // remove old top
                maxHeap.offer(p); // re-add p with its updated frequency
            }

            // Insert newP into the heap if it’s not 0
            if (newP > 0) {
                maxHeap.offer(newP);
            }
        }

        // Build the final list of processes that are *not removed*
        // in ascending order of their original indices
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                remaining.add(finalPriority[i]);
            }
        }

        // Convert to array
        return remaining.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        GetPrioritiesAfterExecution g = new GetPrioritiesAfterExecution();
        int[] result = g.getPrioritiesAfterExecutionApproachTwo(new int[] { 6, 6, 6, 1, 2, 2 });
        for (int i : result) {
            System.out.println(i);
        }
    }
}
