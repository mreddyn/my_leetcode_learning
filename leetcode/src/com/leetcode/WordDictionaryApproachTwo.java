package com.leetcode;

public class WordDictionaryApproachTwo {
    private Trie trie;

    public WordDictionaryApproachTwo() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        boolean isMatch = trie.search(word);
        return isMatch;
    }


    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
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

        public boolean search(String word) {
            return searchMatching(word, root);
        }

        public boolean searchMatching(String word, TrieNode node) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    if (currentChar == '.') {
                        for (TrieNode children : node.getTrieNodes()) {
                            if (children != null && searchMatching(word.substring(i + 1), children)) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    node = node.get(currentChar);
                }

            }
            return node != null && node.isEnd();
        }

        class TrieNode {
            private final int R = 26;
            private TrieNode[] links;
            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
                isEnd = false;
            }

            public TrieNode[] getTrieNodes() {
                return links;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public boolean containsKey(char ch) {
                if (ch == '.') {
                    return false;
                }
                return links[ch - 'a'] != null;
            }

            public void setEnd() {
                this.isEnd = true;
            }

            public boolean isEnd() {
                return this.isEnd;
            }
        }
    }

}



