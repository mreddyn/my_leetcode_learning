package com.company.servicenow;

import java.util.HashSet;

public class NumberOfDistinctSubstringsInString {
    private int countDistinct(String s) {
        HashSet<String> distinctStrings = new HashSet<>();
        int size = s.length();
        // Generate all substrings
        for (int start = 0; start < size; start++) {
            for (int end = start + 1; end <= size; end++) {
                System.out.println(start + " " + end);
                distinctStrings.add(s.substring(start, end));
                System.out.println(s.substring(start, end));
            }
        }
        System.out.println(distinctStrings);
        return distinctStrings.size();
    }

    private int countDistinctTrieApproach(String s) {
        int size = s.length();
        int count = 0;
        Trie root = new Trie();
        for (int start = 0; start < size; start++) {
            Trie temp = root;
            for (int end = start; end < size; end++) {
                char c = s.charAt(end);
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new Trie();
                    System.out.println(s.substring(start, end + 1));
                    count++;
                }
                temp = temp.children[c - 'a'];
            }
        }
        return count;
    }

    class Trie {
        Trie children[];
        boolean isEnd;

        Trie() {
            this.children = new Trie[26];
            this.isEnd = false;
        }
    }

    public static void main(String[] args) {
        NumberOfDistinctSubstringsInString numberOfDistinctSubstringsInString = new NumberOfDistinctSubstringsInString();
        String s = "aabbaba";
        System.out.println(numberOfDistinctSubstringsInString.countDistinct(s));
        System.out.println(numberOfDistinctSubstringsInString.countDistinctTrieApproach(s));
    }
}
