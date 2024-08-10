package com.leetcode_explore.binarySearchTree;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root){
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    boolean helper(TreeNode root, Long minValue, Long maxValue){
        if(root == null){
            return true;
        }
        if(root.val > minValue && root.val < maxValue){
            return helper(root.left, minValue, (long)root.val) && helper(root.right, (long)root.val, maxValue);
        }
        else{
            return false;
        }
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
