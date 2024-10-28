package com.leetcode.medium;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class RemoveSubFoldersFromFileSystem {
    public List<String> removeSubfolders(String[] folder) {
        /*
         * Insert each folder into Trie.
         * Now iterate through the folders again and check if it is sub-folder
         * for subFolder the isEnd is true even before reaching the end of subfolder
         * because we might reach parent folder
         */
        var folderList = new ArrayList<String>();

        // insert all folders into Trie
        TrieNode root = new TrieNode();
        for (String str : folder) {
            // for each folder split it by /
            var names = str.split("/");
            TrieNode cur = root;
            for (String name : names) {
                var map = cur.nodes;
                if (!map.containsKey(name)) {
                    map.put(name, new TrieNode());
                }
                cur = map.get(name);
            }
            cur.isEnd = true;
        }

        // Now Iterate through the folders again
        for (String str : folder) {
            var names = str.split("/");
            boolean isSubFolder = false;
            TrieNode cur = root;
            for (int i = 0; i < names.length; i++) {
                TrieNode node = cur.nodes.get(names[i]);
                if (node.isEnd && i < names.length - 1) {
                    // while iterating through we might reach a parent folder
                    // and it we will see isEnd true
                    isSubFolder = true;
                    break;
                }
                cur = node;
            }

            if (!isSubFolder) {
                folderList.add(str);
            }
        }

        return folderList;
    }

    class TrieNode {
        HashMap<String, TrieNode> nodes;
        boolean isEnd;

        TrieNode() {
            nodes = new HashMap<>();
            this.isEnd = false;
        }
    }
}
