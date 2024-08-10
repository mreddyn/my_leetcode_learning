package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> resultList = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                int difference = getDifferenceOfTwoStrings(query, word);
                if (difference <= 2) {
                    resultList.add(query);
                    break;
                }
            }
        }
        return resultList;
    }

    private int getDifferenceOfTwoStrings(String a, String b) {
        int commonCharCount = 0, n = a.length();
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                commonCharCount++;
            }
        }
        return n - commonCharCount;
    }
}
