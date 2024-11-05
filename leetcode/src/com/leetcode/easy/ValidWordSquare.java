package com.leetcode.easy;

import java.util.List;

public class ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        int n = words.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= n) {
                    // word is too long
                    return false;
                }
                if (i >= words.get(j).length()) {
                    // word is too short
                    return false;
                }
                if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
