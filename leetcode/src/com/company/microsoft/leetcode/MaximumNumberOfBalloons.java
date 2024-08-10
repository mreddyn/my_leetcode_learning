package com.company.microsoft.leetcode;

public class MaximumNumberOfBalloons {
    private int maxNumberOfBalloons(String text) {
        int numberOfBalloons = 0;
        int[] charCount = new int[26];
        for (char c : text.toCharArray()) {
            charCount[c - 'a']++;
        }
        numberOfBalloons = Math.min(charCount['b' - 'a'], charCount['a' - 'a']);
        numberOfBalloons = Math.min(numberOfBalloons, charCount['l' - 'a'] / 2);
        numberOfBalloons = Math.min(numberOfBalloons, charCount['o' - 'a'] / 2);
        numberOfBalloons = Math.min(numberOfBalloons, charCount['n' - 'a']);
        return numberOfBalloons;
    }

    public static void main(String[] args) {
        MaximumNumberOfBalloons maximumNumberOfBalloons = new MaximumNumberOfBalloons();
        String text = "nlaebolko";
        System.out.println(maximumNumberOfBalloons.maxNumberOfBalloons(text));
    }
}
