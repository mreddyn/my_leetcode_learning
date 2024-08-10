package com.leetcode_daily_challenge;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        int[] firstHalfCharacterCount = new int[256];
        int[] secondHalfCharacterCount = new int[256];
        int[] vowelIndices = new int[] { 65, 69, 73, 79, 85, 97, 101, 105, 111, 117 };
        int firstHalfVowelSum, secondHalfVowelSum;
        int stringLength;
        stringLength = s.length();
        for (int index = 0; index < stringLength / 2; index++) {
            char ch = s.charAt(index);
            firstHalfCharacterCount[ch]++;
        }
        for (int index = stringLength / 2; index < stringLength; index++) {
            char ch = s.charAt(index);
            secondHalfCharacterCount[ch]++;
        }
        firstHalfVowelSum = secondHalfVowelSum = 0;
        for (int index = 0; index < 10; index++) {
            firstHalfVowelSum += firstHalfCharacterCount[vowelIndices[index]];
            secondHalfVowelSum += secondHalfCharacterCount[vowelIndices[index]];
        }
        return firstHalfVowelSum == secondHalfVowelSum;
    }

    public static void main(String[] args) {
        System.out.println(new DetermineIfStringHalvesAreAlike().halvesAreAlike("book"));
        System.out.println(new DetermineIfStringHalvesAreAlike().halvesAreAlike("textbook"));
        System.out.println(new DetermineIfStringHalvesAreAlike().halvesAreAlike("AbCdEfGh"));
    }
}
