package com.company.microsoft.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

public class OptimalPartitionOfAString {
    public int partitionString(String s) {
        /*
         * Maintain a HashMap or HashSet to keep track of character frequency, and count
         * for
         * subStrings.
         * Iterate through through the String s.
         * Whenever a character is not present in HashMap add it to hashmap and move on,
         * if it is present in the map, then reset the map and increase the count and
         * add char to map.
         */
        HashSet<Character> seen = new HashSet<>();
        int minPartitionedSubStrings = 1, n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (seen.contains(ch)) {
                minPartitionedSubStrings++;
                seen.clear();
            }
            seen.add(ch);
        }

        return minPartitionedSubStrings;
    }

    public static void main(String[] args) {
        OptimalPartitionOfAString ofAString = new OptimalPartitionOfAString();
        System.out.println(ofAString.partitionString("abacaba"));
        System.out.println(ofAString.partitionString("ssssss"));
    }
}
