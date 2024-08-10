package com.leetcode;

import java.util.HashMap;

public class FruitIntoBaskets {
    private int totalFruit(int[] fruits) {
        int maxNumberOfFruits = 0, windowEnd = 0, windowStart = 0, n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (windowEnd < n) {
            map.put(fruits[windowEnd], map.getOrDefault(fruits[windowEnd], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[windowStart], map.get(fruits[windowStart]) - 1);
                if (map.get(fruits[windowStart]) == 0) {
                    map.remove(fruits[windowStart]);
                }
                windowStart++;
            }
            maxNumberOfFruits = Math.max(maxNumberOfFruits, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return maxNumberOfFruits;
    }

    public static void main(String[] args) {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        System.out.println(fruitIntoBaskets.totalFruit(new int[] { 1, 2, 3, 2, 2 }));
    }
}
