package com.company.servicenow;

import java.util.HashSet;
import java.util.Set;

public class ValidWordsCounter {
    private static int countValidWords(String input) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int count = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int size = input.length();

        Set<Character> consonants = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (!vowels.contains(c))
                consonants.add(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!vowels.contains(c))
                consonants.add(c);
        }

        while (windowEnd < size) {
            char c = input.charAt(windowEnd);
            if (Character.isLetterOrDigit(c)) {
                if (consonants.contains(c) || vowels.contains(c)) {
                    windowEnd++;
                    if (windowEnd - windowStart > 3) {
                        System.out.println(input.substring(windowStart, windowEnd));
                        count++;
                    }
                } else {
                    windowStart = windowEnd + 1;
                    windowEnd = windowStart;

                }
            } else {
                windowStart = windowEnd + 1;
                windowEnd = windowStart;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String input = "This is a string with 1234 words containing a mix of vowels and consonants.";
        System.out.println("Number of valid words: " + countValidWords(input));
    }
}
