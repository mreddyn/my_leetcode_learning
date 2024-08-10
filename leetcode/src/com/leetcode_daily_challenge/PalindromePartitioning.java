package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> resultList;

    private List<List<String>> partition(String s) {
        resultList = new ArrayList<>();
        backtrack(0, new ArrayList<>(), s);
        return resultList;
    }

    private void backtrack(int start, List<String> currentList, String s) {
        if (start >= s.length()) {
            resultList.add(new ArrayList<>(currentList));
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                backtrack(end + 1, currentList, s);
                // remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }

        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        palindromePartitioning.partition(null);
    }
}
