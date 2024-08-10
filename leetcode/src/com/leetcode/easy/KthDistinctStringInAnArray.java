package com.leetcode.easy;

import java.util.HashMap;

public class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> stringFreqMap = new HashMap<>();
        for (String s : arr) {
            stringFreqMap.put(s, stringFreqMap.getOrDefault(s, 0) + 1);
        }

        for (String key : arr) {
            int freq = stringFreqMap.get(key);
            if (freq == 1) {
                k--;
            } else {
                continue;
            }

            if (k == 0) {
                return key;
            }
        }

        return "";
    }
}
