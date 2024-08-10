package com.leetcode;

public class LongestWordInTheDictionary {
    private String longestWordString = "";
    private TrieNode root;

    public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word : words) {
            insert(word);
        }

        for(String word : words) {
            prefix(word);
        }
        return longestWordString;
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

    private void prefix(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            node = node.get(currentChar);
            if (node == null || !node.isEnd()) {
                return;
            }
        }
        if (longestWordString.length() < word.length()
                || longestWordString.length() == word.length() && longestWordString.compareTo(word) > 0) {
            longestWordString = word;
        }
        return;
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


