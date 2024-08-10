package com.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class FirstUnique {
    private ArrayDeque<Integer> queue;
    private Map<Integer, Boolean> isUniqueMap;

    public FirstUnique(int[] nums) {
        queue = new ArrayDeque<>();
        isUniqueMap = new HashMap<>();
        for(int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        while(!queue.isEmpty() && !isUniqueMap.get(queue.peek())) {
            queue.remove();
        }
        if(!queue.isEmpty()) {
            return queue.peek();
        }
         return -1;
    }

    public void add(int value) {
        // if it is unique, mark the number as true and add it to queue
        if(!isUniqueMap.containsKey(value)) {
            isUniqueMap.put(value, true);
            queue.offer(value);
        } else {
            // if it is not unique, then mark it and don't add it to queue
            isUniqueMap.put(value, false);
        }
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique(new int[] { 2, 3, 5 });
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(5);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(2);
        System.out.println(firstUnique.showFirstUnique());
        firstUnique.add(3);
        System.out.println(firstUnique.showFirstUnique());
    }
}
