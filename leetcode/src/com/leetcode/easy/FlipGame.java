package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String currentState) {
        /*
         * We start from i = 1 and check whether current and previous characters of the
         * input string equals to +. If true, then add substring to a list: characters
         * before previous one (concatenating with --) and characters after the current
         * character.
         */
        var res = new ArrayList<String>();
        int n = currentState.length();
        for (int i = 1; i < n; i++) {
            // check if two adjacent chars are ++
            // then add the prefix + -- + suffix as string to final result list
            if (currentState.charAt(i) == '+' && currentState.charAt(i - 1) == '+') {
                var state = currentState.substring(0, i - 1) + "--" + currentState.substring(i + 1, n);
                res.add(state);
            }
        }

        return res;
    }
}
