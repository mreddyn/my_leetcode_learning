package com.leetcode_daily_challenge;

import java.util.Arrays;

public class MinimumNumberOfPushesToTypeWordTwo {
    public int minimumPushes(String word) {
        int minPushes = 0, n = word.length();
        Integer[] charCount = new Integer[26];
        Arrays.fill(charCount, 0);
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            charCount[index]++;
        }
        Arrays.sort(charCount, (a, b) -> (b - a));
        for (int i = 0; i < 26; i++) {
            int freq = charCount[i];
            if (freq == 0) {
                break;
            }
            minPushes += freq * ((i / 8) + 1);
        }
        return minPushes;
    }

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWordTwo mTwo = new MinimumNumberOfPushesToTypeWordTwo();
        System.out.println(mTwo.minimumPushes("abcde"));
        System.out.println(mTwo.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
