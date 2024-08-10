package com.leetcode;

public class SumOfBeautyOfAllSubstrings {
    private int beautySum(String s) {
        System.out.println(s);
        int n = s.length();
        if (n == 1 || n == 2) {
            return 0;
        }
        int beautySum = 0;
        int charFrequencyMap[] = new int[26];
        for (int index = 0; index < n; index++) {
            charFrequencyMap[s.charAt(index) - 'a']++;
            if (index >= 2) {
                beautySum += helper(charFrequencyMap);
            }
        }
        if (n >= 3)
            beautySum += beautySum(s.substring(1));
        return beautySum;
    }

    private int helper(int charFrequencyMap[]) {
        int maxFrequency = 0;
        int minFrequency = Integer.MAX_VALUE;
        for (int frequency : charFrequencyMap) {
            if (frequency > 0) {
                maxFrequency = Math.max(maxFrequency, frequency);
                minFrequency = Math.min(minFrequency, frequency);
            }
        }
        return maxFrequency - minFrequency;
    }

    public static void main(String[] args) {
        String s = "aabcbaa";
        SumOfBeautyOfAllSubstrings sbesl = new SumOfBeautyOfAllSubstrings();
        System.out.println(sbesl.beautySum(s));
    }
}
