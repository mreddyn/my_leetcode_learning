package com.company.doordash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestValidOrdersPath {
    public List<String> getLongestValidPath(List<String> orders) {
        /*
         * Rules for Validity:
         * 
         * Pickup Uniqueness:
         * Each item can only be picked up once.
         * 
         * Delivery Order:
         * An item must be picked up before it can be delivered.
         */

        var pickups = new HashMap<String, Integer>();
        var dropoffs = new HashMap<String, Integer>();

        int n = orders.size();
        int start = 0;
        int maxStart = 0;
        int maxLen = 0;
        var res = new ArrayList<String>();

        for (int end = 0; end < n; end++) {
            var order = orders.get(end);

            // we will try to add the current order
            boolean added = addOrder(order, pickups, dropoffs);

            // if the current order is not valid, we will slide the window
            while (!added && start <= end) {
                removedOrder(orders.get(start), pickups, dropoffs);
                start++;
                added = addOrder(order, pickups, dropoffs);
            }

            // now we have a valid window
            if (!pickups.isEmpty() && pickups.size() == dropoffs.size()) {
                int currentLen = end - start + 1;
                if (currentLen > maxLen) {
                    maxLen = currentLen;
                    maxStart = start;
                }
            }
        }

        for (int i = maxStart; i < maxStart + maxLen; i++) {
            res.add(orders.get(i));
        }

        return res;
    }

    private boolean addOrder(String order, HashMap<String, Integer> pickups, HashMap<String, Integer> dropoffs) {
        char type = order.charAt(0);
        String id = order.substring(1);

        if (type == 'P') {
            // a duplicate pickup is not valid
            if (pickups.containsKey(id)) {
                return false;
            }
            pickups.put(id, 1);
        } else {
            // if this delivery has not been paired with a pickup, we cannot add it
            if (!pickups.containsKey(id)) {
                return false;
            }

            // duplicate delivery is not valid
            if (dropoffs.containsKey(id)) {
                return false;
            }
            dropoffs.put(id, 1);
        }

        return true;
    }

    // Remove a task from the current window, updating the state.
    // Note: When removing a pickup that has been paired with a delivery,
    // we remove both so that the window no longer contains that order.
    private void removedOrder(String order, HashMap<String, Integer> pickups, HashMap<String, Integer> dropoffs) {
        char type = order.charAt(0);
        String id = order.substring(1);

        if (type == 'P') {
            // if this pickup has been paired with a delivery, remove both
            if (dropoffs.containsKey(id)) {
                dropoffs.remove(id);
            }
            pickups.remove(id);
        } else {
            dropoffs.remove(id);
        }
    }

    public static void main(String[] args) {
        LongestValidOrdersPath obj = new LongestValidOrdersPath();
        List<List<String>> testCases = Arrays.asList(
                Arrays.asList("P1", "P1", "P2", "D3", "P1", "P2", "D2", "D1", "P4", "D3", "D1"),
                Arrays.asList("P1", "P1", "D1"),
                Arrays.asList("P1", "P1", "D1", "D1"),
                Arrays.asList("P1", "D2", "D1", "P2"),
                Arrays.asList("P1", "P2", "D1", "D2"),
                Arrays.asList("P1", "D1", "P2", "D2"),
                Arrays.asList("P1", "D2"),
                Arrays.asList("P1", "P2"),
                Arrays.asList("P1", "D1", "D1"),
                Arrays.asList(),
                Arrays.asList("P1", "D1", "P1"),
                Arrays.asList("P1", "D1", "P1", "D1"),
                Arrays.asList("P1", "P2", "D1", "P2"));

        for (List<String> testCase : testCases) {
            System.out.println(obj.getLongestValidPath(testCase));
        }
    }
}
