package com.company.servicenow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    private boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        return wordBreak(s, new HashSet<String>(wordDict), 0, new Boolean[n]);
    }

    private boolean wordBreak(String s, Set<String> wordSet, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && wordBreak(s, wordSet, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;

    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak.wordBreak("leetcode", wordDict));
    }
}
