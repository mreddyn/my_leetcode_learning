package com.company.microsoft.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private List<List<Integer>> combinationsList;

    public List<List<Integer>> combine(int n, int k) {
        combinationsList = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return combinationsList;
    }

    private void backtrack(int start, int n, int k, List<Integer> combination) {
        if (k == 0) {
            combinationsList.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n; i++) {
            combination.add(i);
            backtrack(i + 1, n, k - 1, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
