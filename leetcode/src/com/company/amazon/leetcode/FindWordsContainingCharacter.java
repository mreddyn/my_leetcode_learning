package com.company.amazon.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    private List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        FindWordsContainingCharacter findWordsContainingCharacter = new FindWordsContainingCharacter();
        System.out.println(findWordsContainingCharacter.findWordsContaining(new String[] { "abc" }, 'a'));
    }
}
