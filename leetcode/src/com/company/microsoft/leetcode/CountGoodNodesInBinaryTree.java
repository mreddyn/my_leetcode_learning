package com.company.microsoft.leetcode;

public class CountGoodNodesInBinaryTree {
    int goodNodesCount = 0;
    public int goodNodes(TreeNode root){
        helper(root, root.val);
        return goodNodesCount;
    }
    void helper(TreeNode root, int currentMaxValue){
        if(root == null){
            return;
        }
        if(root.val >= currentMaxValue){
            currentMaxValue = Math.max(currentMaxValue, root.val);
            goodNodesCount++;
        }
        if(root.left != null){
            helper(root.left, currentMaxValue);
        }
        if(root.right != null){
            helper(root.right, currentMaxValue);
        }
    }

    public static void main(String[] args) {
        
    }
    
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
