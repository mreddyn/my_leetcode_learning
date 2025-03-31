package com.company.doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrintAllLongestCommonSubSequenceOfTwoStringArrays {
    private Integer[][] memo;

    private Set<List<String>> printAllLcs(String[] s1, String[] s2) {
        int m = s1.length;
        int n = s2.length;
        memo = new Integer[m + 1][n + 1];
        lcsHelper(s1, s2, 0, 0);
        Map<String, Set<List<String>>> cache = new HashMap<>();
        return constructAllLcs(s1, s2, 0, 0, cache);
    }

    private int lcsHelper(String[] s1, String[] s2, int i, int j) {
        if (i == s1.length || j == s2.length) {
            memo[i][j] = 0;
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        int use = 0;
        int skip_i = 0;
        int skip_j = 0;

        if (s1[i].equals(s2[j])) {
            use = 1 + lcsHelper(s1, s2, i + 1, j + 1);
        } else {
            skip_i = lcsHelper(s1, s2, i + 1, j);
            skip_j = lcsHelper(s1, s2, i, j + 1);
        }

        int best = Math.max(use, Math.max(skip_i, skip_j));
        memo[i][j] = best;
        return best;
    }

    private Set<List<String>> constructAllLcs(String[] s1, String[] s2, int i, int j,
            Map<String, Set<List<String>>> cache) {
        Set<List<String>> result = new HashSet<>();
        String key = i + "," + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // Base case: if one of the arrays is finished, return a set with an empty
        // sequence.
        if (i == s1.length || j == s2.length) {
            result.add(new ArrayList<>());
            cache.put(key, result);
            return result;
        }

        // When the current elements match, include this element and move diagonally.
        if (s1[i].equals(s2[j])) {
            Set<List<String>> temp = constructAllLcs(s1, s2, i + 1, j + 1, cache);
            for (List<String> seq : temp) {
                List<String> newSeq = new ArrayList<>();
                newSeq.add(s1[i]);
                newSeq.addAll(seq);
                result.add(newSeq);
            }
        } else {
            // Otherwise, check which branch (or both) leads to an LCS
            if (memo[i + 1][j] >= memo[i][j + 1]) {
                result.addAll(constructAllLcs(s1, s2, i + 1, j, cache));
            }
            if (memo[i + 1][j] <= memo[i][j + 1]) {
                result.addAll(constructAllLcs(s1, s2, i, j + 1, cache));
            }
        }

        cache.put(key, result);
        return result;
    }
}
