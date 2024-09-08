package com.oa.company.ramp.removeUnderScores;

public class ConvertSentenceToCamelCase {
    public String convert(String src) {
        /*
         * - Split line by words
         * - Any underscores within a word should be removed, so...
         * - Split words by underscores
         * - Rewrite underscores back for any empty strings in result
         * - Iterate over elements in word_parts; ones that are preceded by a "normal"
         * string should be capitalized.
         */
        StringBuilder result = new StringBuilder();
        String[] words = src.split(" ");

        for (String word : words) {
            // for each word split it by underscore.
            String[] strs = word.split("_");

            // Iterate over the array of strings, if we encounter a empty string which is
            // between
            // two words then make the first letter of next word uppercase
            int n = strs.length;
            boolean isPreviousWord = false, isNextWord = false;
            for (int i = 0; i < n; i++) {
                
            }
        }

        return result.toString();
    }
}
