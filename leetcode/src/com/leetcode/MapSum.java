package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    /*
     * Create a trie to store string and corresponding val;
     * For every insert call, insert the key and val into the trie
     * While searching for a prefix, if a prefix is found do a dfs from that node to
     * get the total Sum of all pairs
     */
    private Trie trie;

    public MapSum() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        int allPairsSum = trie.searchPrefix(prefix);
        return allPairsSum;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word, int val) {
            TrieNode node = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char currentChar = word.charAt(i);
                if (!node.children.containsKey(currentChar)) {
                    node.children.put(currentChar, new TrieNode());
                }
                node = node.children.get(currentChar);
            }
            node.isEnd = true;
            node.val = val;
        }

        public int searchPrefix(String prefix) {
            TrieNode node = root;
            int n = prefix.length();
            for (int i = 0; i < n; i++) {
                char currentChar = prefix.charAt(i);
                if (node.children.containsKey(currentChar)) {
                    node = node.children.get(currentChar);
                } else {
                    return 0;
                }
            }
            return dfs(node);
        }

        public int dfs(TrieNode node) {
            int sum = 0;
            for (char currentChar : node.children.keySet()) {
                sum += dfs(node.children.get(currentChar));
            }
            return sum + node.val;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        int val;

        TrieNode() {
            children = new HashMap<>(26);
            isEnd = false;
            val = 0;
        }
    }
}
