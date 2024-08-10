package com.company.microsoft.leetcode.easy;

import com.leetcode_daily_challenge.TreeNode;

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        /*
         * TO find the closest value to a target we need to find absolute difference.
         * Every time we find a lower value we assign it.
         */
        int closestValue = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - closestValue)) {
                closestValue = Math.min(closestValue, root.val);
            } else if (Math.abs(target - root.val) == Math.abs(target - closestValue)) {
                closestValue = Math.min(closestValue, root.val);
            }
            root = (root.val > target) ? root.left : root.right;
        }
        return closestValue;
    }
}
