package com.leetcode_daily_challenge;

import java.util.ArrayDeque;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int minOperationsToMainFolder = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (String log : logs) {
            if (log.equals("../")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                stack.add('(');
            }
        }
        minOperationsToMainFolder = stack.size();
        return minOperationsToMainFolder;
    }

    public int minOperationsApproachTwo(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth == 0) {
                    continue;
                } else {
                    depth--;
                }
            } else if (log.equals("./")) {
                continue;
            } else {
                depth++;
            }
        }
        return depth;
    }
}
