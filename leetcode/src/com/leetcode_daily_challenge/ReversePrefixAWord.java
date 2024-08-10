package com.leetcode_daily_challenge;

public class ReversePrefixAWord {
    private String reversePrefix(String word, char ch) {
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i] == ch) {
                reverseAString(wordArray, i);
                break;
            }
        }
        return new String(wordArray);
    }

    private void reverseAString(char[] wordArray, int end) {
        int start = 0;
        while (start < end) {
            char temp = wordArray[start];
            wordArray[start] = wordArray[end];
            wordArray[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReversePrefixAWord reversePrefixAWord = new ReversePrefixAWord();
        System.out.println(reversePrefixAWord.reversePrefix("abcdefd", 'd'));
    }
}
