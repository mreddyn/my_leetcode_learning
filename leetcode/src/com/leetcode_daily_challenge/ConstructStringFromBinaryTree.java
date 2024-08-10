package com.leetcode_daily_challenge;

public class ConstructStringFromBinaryTree {
    private String tree2str(TreeNode root) {
        return tree2str(root, new StringBuilder()).toString();
    }

    private StringBuilder tree2str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append('(');
            tree2str(root.left, sb);
            sb.append(')');
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append('(');
            tree2str(root.right, sb);
            sb.append(')');
        }
        return sb;
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree constructStringFromBinaryTree = new ConstructStringFromBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(constructStringFromBinaryTree.tree2str(root));
    }
}
