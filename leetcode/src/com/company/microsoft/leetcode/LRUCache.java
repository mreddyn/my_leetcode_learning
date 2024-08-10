package com.company.microsoft.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private DoublyLinkedList head, tail;
    private int count, capacity;
    private Map<Integer, DoublyLinkedList> cache;

    class DoublyLinkedList {
        int key;
        int val;
        DoublyLinkedList left;
        DoublyLinkedList right;
    }

    private void addNode(DoublyLinkedList node) {
        node.left = head;
        node.right = head.right;
        head.right.left = node;
        head.right = node;
    }

    private void removeNode(DoublyLinkedList node) {
        DoublyLinkedList leftNode = node.left;
        DoublyLinkedList rightNode = node.right;
        leftNode.right = rightNode;
        rightNode.left = leftNode;
    }

    private void moveToHead(DoublyLinkedList node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DoublyLinkedList popTail() {
        DoublyLinkedList node = tail.left;
        this.removeNode(node);
        return node;
    }

    LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new DoublyLinkedList();
        tail = new DoublyLinkedList();
        head.left = null;
        tail.right = null;
        head.right = tail;
        tail.left = head;
        count = 0;
        this.capacity = capacity;
    }

    private int get(int key) {
        DoublyLinkedList node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.val;
    }

    private void put(int key, int value) {
        DoublyLinkedList node = cache.get(key);
        if (node == null) {
            node = new DoublyLinkedList();
            node.key = key;
            node.val = value;
            this.cache.put(key, node);
            this.addNode(node);
            ++count;
            if (count > capacity) {
                DoublyLinkedList tail = this.popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            node.val = value;
            this.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
    }
}
