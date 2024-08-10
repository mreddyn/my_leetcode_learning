package com.leetcode_daily_challenge;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {
    private int countNodes(TreeNode root){
        if(root == null) {
            return 0;
        }
        int nodeCount = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode cur = q.poll();
                nodeCount++;
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return nodeCount;
    }
}

