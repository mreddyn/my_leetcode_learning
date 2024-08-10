package com.leetcode;

import java.util.HashSet;

public class LongestWordWithAllPrefixes {
    private String res = "";
    private TrieNode root;
    public String longestWord(String[] words) {
        root = new TrieNode();
        // insert all words into trie
        for (String word : words) {
            insert(word);
        }

        // convert words list into a set
        HashSet<String> seen = new HashSet<>();
        for(String word : words) {
            seen.add(word);
        }
        
        for (String word : words) {
            // search for longest word which has all prefixes in the trie
            searchPrefix(word);
        }
        return res;
    }

    private void insert(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private void searchPrefix(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            node = node.get(currentChar);
            if (node == null || !node.isEnd()) {
                return;
            }
        }
        if ( res.length() < n || res.length() == n && res.toString().compareTo(word) > 0) {
            res = word;
        }
    }

    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            this.isEnd = false;
            this.links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return this.isEnd;
        }
    }
}


