package com.leetcode.medium;

import com.leetcode_daily_challenge.TreeNode;

public class FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // both trees are empty
        if (root1 == null && root2 == null) {
            return true;
        }

        // if either of them is empty then return false
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        // check if same subtrees are equivalent
        boolean noSwap = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

        // check if opposite subtrees are equivalent
        boolean swap = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        return noSwap || swap;
    }
}
