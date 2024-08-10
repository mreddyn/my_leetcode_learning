package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            if (!node.children.containsKey(currentChar)) {
                node.children.put(currentChar, new TrieNode());
            }
            node = node.children.get(currentChar);
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    private boolean searchInNode(String word, TrieNode node) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            if (!node.children.containsKey(currentChar)) {
                if (currentChar == '.') {
                    for (char c : node.children.keySet()) {
                        TrieNode child = node.children.get(c);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(currentChar);
            }
        }
        return node.isEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }
}


