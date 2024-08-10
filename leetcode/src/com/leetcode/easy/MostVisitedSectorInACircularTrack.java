package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorInACircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        /*
         * If start <= end, return the range [start, end].
         * If end < start, return the range [1, end] + range [start, n].
         * 
         * for example if n = 5, rounds = 3,4,5 => 1,2,3,4,5 => 1
         * now here start = 3, and end = 1
         * so we return [1,end] = [1,1] and [start, n] => [3,5]
         */
        List<Integer> mostVisitedTracks = new ArrayList<>();
        int start = rounds[0], end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                mostVisitedTracks.add(i);
            }
            return mostVisitedTracks;
        } else {
            for (int i = 1; i <= end; i++) {
                mostVisitedTracks.add(i);
            }

            for (int i = start; i < n; i++) {
                mostVisitedTracks.add(i);
            }
            return mostVisitedTracks;
        }
    }
}
