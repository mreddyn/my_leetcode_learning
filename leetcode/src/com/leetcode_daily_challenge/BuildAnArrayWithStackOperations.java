package com.leetcode_daily_challenge;

import java.util.List;

public class BuildAnArrayWithStackOperations {
    private List<String> buildArray(int[] target, int n) {
        List<String> result = new java.util.ArrayList<>();
        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            result.add("Push");
            if (target[j] != i) {
                result.add("Pop");
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BuildAnArrayWithStackOperations buildAnArrayWithStackOperations = new BuildAnArrayWithStackOperations();
        int[] target = new int[] { 1, 3 };
        int n = 3;
        List<String> result = buildAnArrayWithStackOperations.buildArray(target, n);
        System.out.println(result);
    }
}
