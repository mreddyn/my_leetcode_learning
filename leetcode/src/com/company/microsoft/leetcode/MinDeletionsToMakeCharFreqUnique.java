package com.company.microsoft.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinDeletionsToMakeCharFreqUnique {
    private static int minDeletions(String s){
        char ch[] = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : ch){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int maxFrequency = 1;
        
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));
        System.out.println(minDeletions("aaabbbcc"));
        System.out.println(minDeletions("ceabaacb"));
    }
}