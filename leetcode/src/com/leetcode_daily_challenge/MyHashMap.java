package com.leetcode_daily_challenge;

public class MyHashMap {
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    final int SIZE = 10001;
    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node node = nodes[index];
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = nodes[index];
        nodes[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        if (nodes[index] == null) {
            return -1;
        } else {
            Node node = nodes[index];
            while (node != null) {
                if (node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        if (nodes[index] == null) {
            return;
        } else {
            Node node = nodes[index];
            while(node != null) {
                if (node.key == key) {
                    node.value = -1;
                    return;
                }
                node = node.next;
            }
        }
    }

    public int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2, 1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }
}
