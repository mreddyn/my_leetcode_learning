package com.leetcode.medium;

import java.util.HashMap;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        /*
         * Tasks with same difficulty level can be done together,
         * in group of 2-tasks or 3-tasks.
         * 
         * So we count the frequency freq for each level.
         * 
         * If freq = 1, not possible, return -1
         * If freq = 2, needs one 2-tasks
         * If freq = 3, needs one 3-tasks
         * If freq = 3k, freq = 3 * k, needs k batches.
         * If freq = 3k + 1, freq = 3 * (k - 1) + 2 + 2, needs k + 1 batches.
         * If freq = 3k + 2, freq = 3 * k + 2, needs k + 1 batches.
         * 
         * To summarize, needs (freq + 2) / 3 batch,
         * return the sum of (freq + 2) / 3 if possible.
         */
        int minRounds = 0;
        var map = new HashMap<Integer, Integer>();

        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq == 1) {
                // not possible to complete tasks, return -1
                return -1;
            } else if (freq % 3 == 0) {
                // if possible to complete in group of 3 then do it.
                minRounds += (freq / 3);
            } else {
                // if not possible in group of three then add one more round
                minRounds += (freq / 3) + 1;
            }
        }

        return minRounds;
    }

}
