package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddStringDifference {
    public String oddString(String[] words) {
        /*
         * as the problem stated there will be two group of words, and we need to
         * identify
         * the group which has only one word.
         * We can group the words based on difference stored as key by hashing it in
         * hashmap.
         */

        var map = new HashMap<Integer, List<String>>();
        for (String word : words) {
            var diff = new ArrayList<Integer>();
            int n = word.length();
            for (int i = 1; i < n; i++) {
                diff.add(word.charAt(i) - word.charAt(i - 1));
            }

            // use the arraylist hash as key for hashmap
            map.computeIfAbsent(diff.hashCode(), x -> new ArrayList<>()).add(word);
        }

        // iterate the HashMap and find out the group which has only one word
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                return entry.getValue().get(0);
            }
        }

        return "";
    }
}
