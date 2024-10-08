package com.leetcode.medium;

public class WordDictionary {
    private TrieNode root;

    WordDictionary() {
        this.root = new TrieNode();
    }

    void addWord(String word) {
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
        TrieNode node = root;
        return searchMatching(word, node);
    }

    private boolean searchMatching(String word, TrieNode node) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                if (currentChar == '.') {
                    for (TrieNode child : node.getTrieNodes()) {
                        if (child != null && searchMatching(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.get(currentChar);
            }
        }

        return node != null && node.isEnd;
    }

    class TrieNode {
        private TrieNode[] links;
        private boolean isEnd;

        TrieNode() {
            this.links = new TrieNode[26];
            this.isEnd = false;
        }

        TrieNode[] getTrieNodes() {
            return this.links;
        }

        TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, TrieNode node) {
            this.links[ch - 'a'] = node;
        }

        boolean containsKey(char ch) {
            if (ch == '.') {
                return false;
            }
            return links[ch - 'a'] != null;
        }

        void setIsEnd() {
            this.isEnd = true;
        }

        boolean isEnd() {
            return this.isEnd;
        }
    }
}
