package com.company.doordash;

import java.util.*;

public class LongestValidSubarrayOptimizedCounter {
    public static void main(String[] args) {
        // Test case: expected output is the full array ["P1", "D1", "P1", "D1"]
        String[] orders = { "P1", "D1", "P1", "D1" };
        System.out.println("Longest valid subarray: " + longestValidSubarray(orders));
        System.out.println(longestValidSubarray(new String[] { "P1", "D1", "P1", "D1" }));
        System.out.println(longestValidSubarray(new String[] { "P1", "P1", "P2", "D3", "P1", "P2", "D2", "D1", "P4",
                "D3", "D1" }));
        System.out.println(longestValidSubarray(new String[] { "D1", "P1" }));
    }

    public static List<String> longestValidSubarray(String[] orders) {
        int n = orders.length;
        int left = 0, maxLen = 0, maxLeft = 0;
        // Map to track count for each order ID.
        // A pickup increases count, a delivery decreases count.
        HashMap<String, Integer> orderCount = new HashMap<>();

        for (int right = 0; right < n; right++) {
            String task = orders[right];
            // Attempt to add the new task into the current window.
            boolean added = addTask(task, orderCount);

            // If the new task violates the rules, slide the window from the left.
            while (!added && left <= right) {
                removeTask(orders[left], orderCount);
                left++;
                added = addTask(task, orderCount);
            }

            // If the window is "complete" (all orders have been picked up and delivered)
            // then orderCount will be empty.
            if (orderCount.isEmpty()) {
                int currentLen = right - left + 1;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxLeft = left;
                }
            }
        }

        // Build the longest valid subarray.
        List<String> result = new ArrayList<>();
        for (int i = maxLeft; i < maxLeft + maxLen; i++) {
            result.add(orders[i]);
        }
        return result;
    }

    // Adds a task to the current window's state.
    // For a pickup ('P'), if the order is already pending (count == 1), it's
    // invalid.
    // For a delivery ('D'), it is valid only if a pickup exists (count >= 1).
    private static boolean addTask(String task, HashMap<String, Integer> orderCount) {
        char type = task.charAt(0);
        String id = task.substring(1);
        if (type == 'P') {
            int count = orderCount.getOrDefault(id, 0);
            if (count == 1) { // Cannot pick up again if already pending.
                return false;
            }
            orderCount.put(id, count + 1);
            return true;
        } else { // Delivery
            int count = orderCount.getOrDefault(id, 0);
            if (count == 0) { // Cannot deliver if no pickup.
                return false;
            }
            count = count - 1;
            if (count == 0) {
                orderCount.remove(id);
            } else {
                orderCount.put(id, count);
            }
            return true;
        }
    }

    // Reverses the effect of a task as the window slides forward.
    private static void removeTask(String task, HashMap<String, Integer> orderCount) {
        char type = task.charAt(0);
        String id = task.substring(1);
        if (type == 'P') {
            // Removing a pickup means reducing the count.
            int count = orderCount.getOrDefault(id, 0);
            if (count <= 1) {
                orderCount.remove(id);
            } else {
                orderCount.put(id, count - 1);
            }
        } else { // Delivery
            // Removing a delivery "undoes" the decrement.
            int count = orderCount.getOrDefault(id, 0);
            orderCount.put(id, count + 1);
        }
    }
}
