package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IndexPairsOfString {

    public int[][] indexPairs(String text, String[] words) {
        // insert the words into trie and search text in the trie
        // if given text is 'ababa' then search 'ababa', 'baba', 'aba', 'ba', and 'a'
        // if found note the startIndex and endIndex
        // insert the words into Trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<int[]> indicesList = trie.search(text);
        int[][] result = new int[indicesList.size()][2];
        for (int i = 0; i < indicesList.size(); i++) {
            result[i] = indicesList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        IndexPairsOfString indexPairsOfString = new IndexPairsOfString();
        indexPairsOfString.indexPairs("thestoryofleetcodeandme", new String[] { "leetcode", "fleet", "story" });
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public List<int[]> search(String word) {
        int n = word.length();
        List<int[]> list = new ArrayList<>();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char currentChar = word.charAt(i);
            System.out.println(word.substring(i, n));
            int movingIndex = i;
            while (node.containsKey(currentChar)) {
                node = node.get(currentChar);
                if (node.isEnd()) {
                    System.out.println("indices : " + i + " " + movingIndex);
                    list.add(new int[] { i, movingIndex });
                }
                movingIndex++;
                if (movingIndex == n) {
                    break;
                } else {
                    currentChar = word.charAt(movingIndex);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }
        return list;
    }
}

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[R];
        this.isEnd = false;
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
