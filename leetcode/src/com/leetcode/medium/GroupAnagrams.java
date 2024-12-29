package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        var map = new HashMap<String, List<String>>();
        for (String str : strs) {
            var ch = str.toCharArray();
            Arrays.sort(ch);
            var key = new String(ch);
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
        }
        res.addAll(map.values());
        return res;
    }
}
