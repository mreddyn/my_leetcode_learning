package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        /*
         * Since two words can be same if they have same set of characters regardless of
         * their
         * char frequencies.
         * We will maintain a HashMap<word, frequency> to count the similar pairs
         * So for every word we will create a set of chars and insert into the Hashmap
         */
        int similarPairsCount = 0;
        var map = new HashMap<Set<Character>, Integer>();
        for (String word : words) {
            var set = new HashSet<Character>();
            int n = word.length();
            for (int i = 0; i < n; i++) {
                set.add(word.charAt(i));
            }

            int freq = map.getOrDefault(set, 0);
            similarPairsCount += freq;
            map.put(set, freq + 1);
        }

        return similarPairsCount;
    }

    public int similarPairsApproachTwo(String[] words) {
        int similarPairsCount = 0;
        var map = new HashMap<Integer, Integer>();
        for (String word : words) {
            int bitmask = 0;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                bitmask |= (1 << (word.charAt(i) - 'a'));
            }
            System.out.println("bitmask : " + bitmask);
            int freq = map.getOrDefault(bitmask, 0);
            similarPairsCount += freq;
            map.put(bitmask, freq + 1);
            System.out.println(map);
        }

        return similarPairsCount;
    }

    public static void main(String[] args) {
        CountPairsOfSimilarStrings cStrings = new CountPairsOfSimilarStrings();
        System.out.println(cStrings.similarPairsApproachTwo(new String[] { "aba", "aabb", "abcd", "bac", "aabc" }));
    }
}
