package com.leetcode.medium;

public class MovePiecesToObtainAString {
    public boolean canChange(String start, String target) {
        // check if the order of chars in start and target is same.
        // if they are not same we can return false;
        if (!isOrderSame(start, target)) {
            return false;
        }

        // now If the i'th letter in start is 'L', its index in start must be greater
        // than or equal to its index in target. The same applies for 'R', but the index
        // in start must be less than or equal to the index in target.
        int start_index = 0, target_index = 0, n = start.length();
        while (start_index < n || target_index < n) {
            // skip all '_' in start and target strings
            while (start_index < n && start.charAt(start_index) == '_') {
                start_index++;
            }

            while (target_index < n && target.charAt(target_index) == '_') {
                target_index++;
            }

            // check if reached end of strings
            if (start_index == n || target_index == n) {
                return start_index == target_index;
            }

            // if we see different chars at these indices then return false
            if (start.charAt(start_index) != target.charAt(target_index)) {
                return false;
            }

            if (start.charAt(start_index) == 'L') {
                if (start_index < target_index) {
                    return false;
                }
            } else {
                if (start_index > target_index) {
                    return false;
                }
            }
            start_index++;
            target_index++;
        }

        return true;
    }

    private boolean isOrderSame(String start, String target) {
        int n = start.length();
        var start_order = new StringBuilder();
        var target_order = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (start.charAt(i) != '_') {
                start_order.append(start.charAt(i));
            }

            if (target.charAt(i) != '_') {
                target_order.append(target.charAt(i));
            }
        }

        return start_order.equals(target_order);
    }
}
