package com.leetcode_daily_challenge;

public class SortVowelsInAString {
    private String sortVowels(String s) {
        int[] vowelsCount = new int[52];
        char ch[] = s.toCharArray();
        int totalVowels = 0;
        for (char c : ch) {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowelsCount[c - 'A']++;
                totalVowels++;
            } else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelsCount[c - 'a' + 26]++;
                totalVowels++;
            }
        }
        char[] vowelsString = new char[totalVowels];
        int index = 0;
        for (int i = 0; i < 52; i++) {
            while (vowelsCount[i] > 0) {
                if (i < 26) {
                    vowelsString[index++] = (char) ('A' + i);
                } else {
                    vowelsString[index++] = (char) ('a' + i - 26);
                }
                vowelsCount[i]--;
            }
        }
        char[] result = new char[ch.length];
        int vowelIndex = 0;
        int resultIndex = 0;
        for (char c : ch) {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                result[resultIndex++] = vowelsString[vowelIndex++];
            } else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                result[resultIndex++] = vowelsString[vowelIndex++];
            } else {
                result[resultIndex++] = c;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        SortVowelsInAString sv = new SortVowelsInAString();
        System.out.println(sv.sortVowels("lEetcOde"));
    }
}
