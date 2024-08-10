package com.leetcode_daily_challenge;

public class LengthOfLastWord {
    private int lengthOfLastWord(String s) {
        int n = s.length(), wordStartIndex, wordEndIndex;
        wordEndIndex = wordStartIndex = -1;
        int index = n - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        wordEndIndex = index;
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
        }
        wordStartIndex = index;

        return wordEndIndex - wordStartIndex;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("joyboy"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("y"));
    }
}
