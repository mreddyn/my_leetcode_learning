package com.company.amazon.leetcode.medium;

import java.util.HashMap;

public class CopyListWithRandomPointer {
    HashMap<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // if we already processed the current node then return the
        // newly processed node
        if (visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }

        // if not create a new node
        Node node = new Node(head.val);

        // save this new node
        visitedHash.put(head, node);

        // Recursively copy the remaining linked list starting once from the next
        // pointer and then from the random pointer.
        // Thus we have two independent recursive calls.
        // Finally we update the next and random pointers for the new node created.
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    HashMap<Node, Node> visited = new HashMap<>();

    public Node copyRandomListApproachTwo(Node head) {
        if (head == null) {
            return head;
        }

        Node oldNode = head;

        // create a copy of oldNode
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        // Iterate the linkedList until all nodes are cloned
        while (oldNode != null) {
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            // move onto next node in the original list
            newNode = newNode.next;
            oldNode = oldNode.next;
        }

        return this.visited.get(head);
    }

    private Node getClonedNode(Node node) {
        if (node != null) {
            // check if we already cloned
            if (this.visited.containsKey(node)) {
                return this.visited.get(node);
            } else {
                // create a new node, store it in map and return
                Node newNode = new Node(node.val);
                this.visited.put(node, newNode);
                return newNode;
            }
        } else {
            return null;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
