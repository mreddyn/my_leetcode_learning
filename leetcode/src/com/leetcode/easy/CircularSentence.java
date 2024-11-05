package com.leetcode.easy;

public class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        if (sentence.charAt(0) != sentence.charAt(n - 1)) {
            return false;
        }

        var words = sentence.split(" ");
        char prevWordLastChar = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            if (prevWordLastChar != words[i].charAt(0)) {
                return false;
            }
            prevWordLastChar = words[i].charAt(words[i].length() - 1);
        }

        return true;
    }

    public boolean isCircularSentenceApproachTwo(String sentence) {
        int n = sentence.length();
        for (int i = 0; i < n; i++) {
            if (sentence.charAt(i) == ' ') {
                // if we encounter a space then it indicates that
                // there are words either side of it
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }

        // once we reach end of sentence, we also need to compare
        // first char of first word and last char of last word
        return sentence.charAt(0) == sentence.charAt(n - 1);
    }

    public static void main(String[] args){
      CircularSentence circularSentence = new CircularSentence();
      System.out.println(circularSentence.isCircularSentence("helloh"));
    }
}
