package com.leetcode_daily_challenge;

public class ReverseWordsInAStringThree {
    public String reverseWords(String s) {
        char ch[] = s.toCharArray();
        int wordEndIndex = 0;
        int wordStartIndex = 0;
        for (int index = 0; index < ch.length; index++) {
            if (ch[index] == ' ') {
                wordEndIndex = index - 1;
                reverseWord(ch, wordStartIndex, wordEndIndex);
                wordStartIndex = index + 1;
            }
        }
        reverseWord(ch, wordStartIndex, ch.length - 1);
        String resultString = new String(ch);
        System.out.println(resultString);
        return resultString;
    }

    private void reverseWord(char[] ch, int wordStartIndex, int wordEndIndex) {
        while (wordStartIndex < wordEndIndex) {
            char temp = ch[wordStartIndex];
            ch[wordStartIndex] = ch[wordEndIndex];
            ch[wordEndIndex] = temp;
            wordStartIndex++;
            wordEndIndex--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        ReverseWordsInAStringThree rw = new ReverseWordsInAStringThree();
        rw.reverseWords(s);
    }
}
