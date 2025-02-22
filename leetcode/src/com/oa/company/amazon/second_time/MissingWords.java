package com.oa.company.amazon.second_time;

import java.util.ArrayList;
import java.util.List;

public class MissingWords {
    /*
     * Complete the 'missingWords' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. STRING t
     */

    public List<String> missingWords(String s, String t) {
        List<String> missing = new ArrayList<>();

        // Split both s and t into word arrays
        String[] sWords = s.split(" ");
        String[] tWords = t.split(" ");

        // Use a pointer for the tWords
        int tIndex = 0;

        // Iterate over words in s
        for (String word : sWords) {
            // If there's still a word left in t and it matches the current word in s
            // move the pointer in t (i.e., this word is part of the subsequence)
            if (tIndex < tWords.length && word.equals(tWords[tIndex])) {
                tIndex++;
            } else {
                // Otherwise, it's missing
                missing.add(word);
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        // Sample test
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";

        List<String> result = new MissingWords().missingWords(s, t);
        for (String w : result) {
            System.out.println(w);
        }
    }
}
