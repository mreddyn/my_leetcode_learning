package com.company.servicenow;

import java.util.LinkedList;
import java.util.Queue;

public class SumRootToLeafNumbers {
    private int sumNumbers(TreeNode root){
        int totalSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null){
                    totalSum += cur.val;
                    continue;
                }

                if(cur.left != null){
                    cur.left.val = cur.val * 10 + cur.left.val;
                    queue.add(cur.left);
                }

                if(cur.right != null){
                    cur.right.val = cur.val * 10 + cur.right.val;
                    queue.add(cur.right);
                }
            }
        }

        return totalSum;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
