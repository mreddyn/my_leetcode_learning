package com.oa.company.goldmansachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AutocorrectPrototype {
    public String[][] autocorrectPrototype(int n, String[] words, String[] queries) {
        /*
         * Given 2 arrays, words[n], and queries[q], for each query, return an array of
         * the strings that are anagrams, sorted alphabetically ascending.
         */
        var map = groupAnagrams(words);
        System.out.println(map);
        var res = new String[queries.length][];
        for (int i = 0; i < n; i++) {
            var arr = queries[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            res[i] = map.getOrDefault(key, new ArrayList<>()).toArray(new String[0]);
            Arrays.sort(res[i]);
        }
        return res;
    }

    private HashMap<String, List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (String str : strs) {
            var arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return map;
    }

    public static void main(String[] args) {
        AutocorrectPrototype obj = new AutocorrectPrototype();
        int n = 2;
        String[] words = { "duel", "speed", "dule", "cars" };
        String[] queries = { "dpese", "deul" };
        String[][] res = obj.autocorrectPrototype(n, words, queries);
        for (String[] arr : res) {
            for (String str : arr) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
