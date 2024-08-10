package com.company.microsoft.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class NArrayTreePostOrderTraversal {
    private List<Integer> postOrderList = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return postOrderList;
        }
        for (Node node : root.children) {
            postorder(node);
        }
        postOrderList.add(root.val);
        return postOrderList;
    }

    class Node {
        int val;
        List<Node> children;

        Node() {
        }

        Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }
}
