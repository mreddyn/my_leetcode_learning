package com.company.doordash;

import java.util.HashMap;

public class NumberOfDistinctSubStringsInString {
    public int countDistinct(String s) {
        int n = s.length();
        int count = 0;
        Node root = new Node();

        for (int i = 0; i < n; i++) {
            Node curr = root;
            for (int j = i; j < n; j++) {
                if (!curr.children.containsKey(s.charAt(j))) {
                    curr.children.put(s.charAt(j), new Node());
                    count++;
                }
                curr = curr.children.get(s.charAt(j));
            }
        }

        return count;
    }

    class Node {
        HashMap<Character, Node> children;

        Node() {
            children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        NumberOfDistinctSubStringsInString number = new NumberOfDistinctSubStringsInString();
        System.out.println(number.countDistinct("aabbaba"));
    }
}
