package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class CheckIfOneStringSwapCanMakeEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        List<Integer> list = new ArrayList<>();

        // find the number of non-equal positions
        int nonEqualPositionsCount = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
                nonEqualPositionsCount++;
            }
            if (list.size() > 2) {
                return false;
            }
        }

        if (nonEqualPositionsCount == 0) {
            return true;
        }

        if (nonEqualPositionsCount == 2 && (s1.charAt(list.get(0)) == s2.charAt(list.get(1))) && (s1
                .charAt(list.get(1)) == s2.charAt(list.get(0)))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckIfOneStringSwapCanMakeEqual cEqual = new CheckIfOneStringSwapCanMakeEqual();
        System.out.println(cEqual.areAlmostEqual("bank", "kanb"));
    }
}
