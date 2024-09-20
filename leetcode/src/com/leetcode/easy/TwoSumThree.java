package com.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSumThree {
    private List<Integer> nums;
    private HashMap<Integer, Integer> map;

    public TwoSumThree() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    public void add(int number) {
        nums.add(number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            int num = nums.get(i);
            int target = value - num;
            if (num == target && map.get(num) > 1) {
                return true;
            } else if (num != target && map.containsKey(target)) {
                return true;
            }
        }

        return false;
    }
}
