package com.company.facebook;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
    private List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<CustomPair> queue = new java.util.LinkedList<>();
        HashMap<Integer, List<Integer>> columnTable = new HashMap<>();

        int col = 0;
        int minColumn = 0, maxColumn = 0;
        queue.add(new CustomPair(root, col));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                CustomPair pair = queue.poll();
                if (pair.node == null) {
                    continue;
                }
                if (!columnTable.containsKey(pair.col)) {
                    columnTable.put(pair.col, new java.util.ArrayList<>());
                }
                columnTable.get(pair.col).add(pair.node.val);
                minColumn = Math.min(minColumn, pair.col);
                maxColumn = Math.max(maxColumn, pair.col);
                if (pair.node.left != null) {
                    queue.add(new CustomPair(pair.node.left, pair.col - 1));
                }
                if (pair.node.right != null) {
                    queue.add(new CustomPair(pair.node.right, pair.col + 1));
                }
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            result.add(columnTable.get(i));
        }
        return result;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        };

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        };
    }

    class CustomPair {
        TreeNode node;
        int col;

        CustomPair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }

    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal b = new BinaryTreeVerticalOrderTraversal();
        TreeNode root = b.new TreeNode(3);
        root.left = b.new TreeNode(9);
        root.right = b.new TreeNode(20);
        root.right.left = b.new TreeNode(15);
        root.right.right = b.new TreeNode(7);
        System.out.println(b.verticalOrder(root));
    }
}
