package com.company.rubrik.onepoint3acres;

import java.util.*;

public class MinDifferenceSlidingWindow {
    private final int K;
    private final Deque<Integer> windowQueue;
    private final TreeSet<Integer> windowSet;
    private final TreeMap<Integer, Integer> minDiffs;

    public MinDifferenceSlidingWindow(int K) {
        this.K = K;
        this.windowQueue = new LinkedList<>();
        this.windowSet = new TreeSet<>();
        this.minDiffs = new TreeMap<>();
    }

    // Adds a new number to the window and updates the data structures
    public void addNumber(int num) {
        // If window is not empty, find lower and higher neighbors
        if (!windowSet.isEmpty()) {
            Integer lower = windowSet.lower(num);
            Integer higher = windowSet.higher(num);

            if (lower != null) {
                addDifference(num - lower);
            }
            if (higher != null) {
                addDifference(higher - num);
            }
            if (lower != null && higher != null) {
                removeDifference(higher - lower);
            }
        }

        // Add the new number to windowSet and windowQueue
        windowSet.add(num);
        windowQueue.addLast(num);

        // If window size exceeds K, remove the oldest element
        if (windowQueue.size() > K) {
            int removed = windowQueue.removeFirst();
            // Find neighbors of the removed element
            Integer lower = windowSet.lower(removed);
            Integer higher = windowSet.higher(removed);

            // Remove differences involving the removed element
            if (lower != null) {
                removeDifference(removed - lower);
            }
            if (higher != null) {
                removeDifference(higher - removed);
            }
            if (lower != null && higher != null) {
                addDifference(higher - lower);
            }

            // Remove the element from the set
            windowSet.remove(removed);
        }
    }

    // Retrieves the current minimum difference
    public int getMinDifference() {
        if (windowSet.size() < 2) {
            return 0; // As per example, return 0 when less than 2 elements
        }
        return minDiffs.firstKey();
    }

    // Helper method to add a difference to minDiffs
    private void addDifference(int diff) {
        minDiffs.put(diff, minDiffs.getOrDefault(diff, 0) + 1);
    }

    // Helper method to remove a difference from minDiffs
    private void removeDifference(int diff) {
        if (minDiffs.containsKey(diff)) {
            int count = minDiffs.get(diff);
            if (count == 1) {
                minDiffs.remove(diff);
            } else {
                minDiffs.put(diff, count - 1);
            }
        }
    }

    public static void main(String[] args) {
        int K = 3;
        int[] stream = { 1, 2, 8, 4, 7 };
        MinDifferenceSlidingWindow mdw = new MinDifferenceSlidingWindow(K);
        List<Integer> answers = new ArrayList<>();

        for (int num : stream) {
            mdw.addNumber(num);
            answers.add(mdw.getMinDifference());
        }

        System.out.println("Stream: " + Arrays.toString(stream));
        System.out.println("Min differences: " + answers);
        // Expected Output: [0, 1, 1, 2, 1]
    }
}
