package com.leetcode_daily_challenge;

import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        int dictionarySize = dictionary.size();
        String[] words = sentence.split(" ");
        Trie trie = new Trie();
        for (int i = 0; i < dictionarySize; i++) {
            String currentRootWord = dictionary.get(i);
            trie.insert(currentRootWord);
        }
        for (int i = 0; i < words.length; i++) {
            words[i] = trie.shortestRoot(words[i]);
        }

        // use StringBuilder to build the splitted strs into single string
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
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

    public String shortestRoot(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                return word;
            }
            node = node.get(currentChar);
            if (node.isEnd()) {
                return word.substring(0, i + 1);
            }
        }
        return word;
    }
}

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public boolean isEnd() {
        return this.isEnd;
    }

    public void setEnd() {
        this.isEnd = true;
    }
}
