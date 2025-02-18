package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {
    private Map<Integer, TreeSet<Integer>> container;
    private Map<Integer, Integer> indexToNumber;

    public NumberContainers() {
        container = new HashMap<>();
        indexToNumber = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            container.get(oldNumber).remove(index);
            if (container.get(oldNumber).isEmpty()) {
                container.remove(oldNumber);
            }
        }

        indexToNumber.put(index, number);
        if (!container.containsKey(number)) {
            container.put(number, new TreeSet<>());
        }
        container.get(number).add(index);
    }

    public int find(int number) {
        if (!container.containsKey(number)) {
            return -1;
        }

        return container.get(number).first();
    }

    public static void main(String[] args) {
        NumberContainers solution = new NumberContainers();
        System.out.println(solution.find(10));
        solution.change(2, 10);
        solution.change(1, 10);
        solution.change(3, 10);
        solution.change(5, 10);
        System.out.println(solution.find(10));
        solution.change(1, 20);
        System.out.println(solution.find(10));
    }
}
