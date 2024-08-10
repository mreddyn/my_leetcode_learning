package com.company.confluent;

import java.util.HashMap;
import java.util.Map;

// check this: https://www.1point3acres.com/bbs/thread-915936-1-1.html
//void put(String key, int val); // save a new event
//int getKey(String key); // If you have this key in the past 5min, return value, otherwise it is exception
//void delete(String key);
//int avg(); // Return the average of all events in the past 5min
public class WindowHashMap {
    Node head, tail;
    Map<String, Node> map = new HashMap<>();
    int expire, sum = 0, count = 0;

    public static void main(String[] args) throws InterruptedException {
        WindowHashMap wh = new WindowHashMap(10);
        wh.put("hi1", 1);
//        Thread.sleep(5000);
        wh.put("hi2", 2);
        System.out.println(wh.avg());
    }

    WindowHashMap(int expire) {
        Long time = System.currentTimeMillis();
        head = new Node("", 0, time);
        tail = new Node("", 0, time);
        head.next = tail;
        tail.prev = head;
        this.expire = expire * 1000;
    }

    void put(String key, int val) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        clean();
        insert(new Node(key, val, System.currentTimeMillis()));
        sum += val;
        count++;
    }

    int get(String key) {
        clean();
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    Double avg() {
        clean();
        if (count == 0) return 0.0; // Avoid division by zero
        return (double) sum / count;
    }

    void clean() {
        long currTime = System.currentTimeMillis();
        Node curr = tail.prev;
        while (curr != head) {
            if (currTime - curr.time > expire) {
                remove(curr);
                count--;
                sum -= curr.val;
            } else {
                break; // Since the list is ordered, no need to check earlier nodes
            }
            curr = curr.prev;
        }
    }

    void insert(Node node) {
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }


    void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    void delete(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            count--;
            sum -= node.val;
        }
    }


}

class Node {
    String key;
    int val;
    Long time;
    Node prev, next;

    Node(String key, int val, long time) {
        this.key = key;
        this.val = val;
        this.time = time;
    }
}