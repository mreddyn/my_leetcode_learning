package com.oa.company.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPathWithDifferentAdjacentCharacters {
    int max_path = 0;

    public int longestPath(int[] parent, String s) {
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i < parent.length; i++) {
            int p = parent[i];
            map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }
        dfs(0, map, s);
        return max_path;
    }

    private int dfs(int cur, Map<Integer, List<Integer>> map, String s) {
        int max_one = -1;
        int max_two = -1;

        for (int c : map.getOrDefault(cur, new ArrayList<>())) {
            int res = dfs(c, map, s);
            if (s.charAt(cur) != s.charAt(c)) {
                if (res > max_one) {
                    max_two = max_one;
                    max_one = res;
                } else if (res > max_two) {
                    max_two = res;
                }
            }
        }

        max_one = max_one == -1 ? 0 : max_one;
        max_two = max_two == -1 ? 0 : max_two;
        max_path = Math.max(max_path, max_one + max_two + 1);
        return max_one + 1;
    }
}
