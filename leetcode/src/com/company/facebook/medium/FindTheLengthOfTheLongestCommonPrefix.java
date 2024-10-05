package com.company.facebook.medium;

import java.util.HashSet;

public class FindTheLengthOfTheLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longestCommonPrefixLength = 0;
        // set to store all arr1 prefixes
        var arr1Prefixes = new HashSet<Integer>();

        // build all possible prefixes from arr1
        for (int num : arr1) {
            while (!arr1Prefixes.contains(num) && num > 0) {
                // insert current num as prefix
                arr1Prefixes.add(num);
                // generate next prefix from num by removing last digit
                num /= 10;
            }
        }

        // now check the values from arr2 for longest prefix
        for (int num : arr2) {
            while (!arr1Prefixes.contains(num) && num > 0) {
                // if current num is not a prefix then reduce it by a digit and try again
                num /= 10;
            }

            if (num > 0) {
                // using Math.log10(num) +1 returns the number of digits in num
                int curPrefixLength = (int) Math.log10(num) + 1;
                longestCommonPrefixLength = Math.max(longestCommonPrefixLength, curPrefixLength);
            }
        }

        return longestCommonPrefixLength;
    }

    public int longestCommonPrefixApproachTwo(int[] arr1, int[] arr2) {
        int longestCommonPrefixLength = 0;
        Trie trie = new Trie();

        // insert all numbers from arr1 into trie
        for (int num : arr1) {
            trie.insert(num);
        }

        for (int num : arr2) {
            int curPrefixLength = trie.findLongestPrefix(num);
            longestCommonPrefixLength = Math.max(curPrefixLength, longestCommonPrefixLength);
        }

        return longestCommonPrefixLength;
    }

    class TrieNode {
        // each node can have up to 10 possible children i.e, digits 0-9
        TrieNode[] children = new TrieNode[10];
    }

    class Trie {
        TrieNode root = new TrieNode();

        // insert the number into trie after treating it as string of digits
        void insert(int num) {
            TrieNode node = root;
            String numStr = Integer.toString(num);
            int n = numStr.length();
            for (int i = 0; i < n; i++) {
                int idx = numStr.charAt(i) - '0';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
        }

        int findLongestPrefix(int num) {
            TrieNode node = root;
            String numStr = Integer.toString(num);
            int n = numStr.length();
            int prefixLength = 0;
            for (int i = 0; i < n; i++) {
                int idx = numStr.charAt(i) - '0';
                // increase the length if current digit matches
                if (node.children[idx] != null) {
                    prefixLength++;
                    node = node.children[idx];
                } else {
                    // stop
                    break;
                }
            }
            return prefixLength;
        }
    }
}
