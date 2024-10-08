package com.leetcode.medium;

public class ImplementTrie {
    private TrieNode root;

    ImplementTrie() {
        root = new TrieNode();
    }

    void insert(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setIsEnd();
    }

    boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String prefix) {
        int n = prefix.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char currentChar = prefix.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }

    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;

        TrieNode() {
            links = new TrieNode[26];
            isEnd = false;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        void setIsEnd() {
            this.isEnd = true;
        }

        boolean isEnd() {
            return this.isEnd;
        }
    }
}
