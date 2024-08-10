package com.company.servicenow;

public class VowelsOfAllSubstrings {
    private long countVowels(String word) {
        long totalSumOfVowels = 0;
        long n;
        n = word.length();
        for (int index = 0; index < n; index++) {
            char c = word.charAt(index);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                totalSumOfVowels += countVowelsInSubstring(n, index);
            }
        }

        return totalSumOfVowels;
    }

    private long countVowelsInSubstring(long length, int index) {
        long count = 0;
        count = (index + 1) * (length - index);
        return count;
    }

    public static void main(String[] args) {
        VowelsOfAllSubstrings vowelsOfAllSubstrings = new VowelsOfAllSubstrings();
        System.out.println(vowelsOfAllSubstrings.countVowels("aba"));
    }
}
