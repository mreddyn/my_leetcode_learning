package com.leetcode_daily_challenge;

public class StepByStepDirectionsFromBinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        /*
         * Find lowest common ancestor of startValue, and destValue.
         * Find path from LCA to startValue (replace all values with 'U' since we only
         * up direction)
         * Find path from LCA to destValue
         * append both these paths
         */
        TreeNode lowestCommonAncestor = findLowestCommonAncestor(root, startValue, destValue);

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPathFromLCAToNode(lowestCommonAncestor, startValue, pathToStart);
        findPathFromLCAToNode(lowestCommonAncestor, destValue, pathToDest);

        StringBuilder directions = new StringBuilder();

        // replace all chars in pathToStart to 'U' and add it to directions
        directions.append("U".repeat(pathToStart.length()));

        // add pathToDest to directions
        directions.append(pathToDest);

        return directions.toString();
    }

    private TreeNode findLowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLowestCommonAncestor(root.left, p, q);
        TreeNode right = findLowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }

    private boolean findPathFromLCAToNode(TreeNode node, int targetValue, StringBuilder path) {
        if (node == null) {
            return false;
        }
        if (node.val == targetValue) {
            return true;
        }
        // Try left subtree
        path.append('L');
        if (findPathFromLCAToNode(node.left, targetValue, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        // Try right subTree
        path.append('R');
        if (findPathFromLCAToNode(node.right, targetValue, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }
}
