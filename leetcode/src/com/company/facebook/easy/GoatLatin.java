package com.company.facebook.easy;

import java.util.Arrays;
import java.util.HashSet;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        var words = sentence.split(" ");
        var result = new StringBuilder();
        var vowelSet = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int wordIndex = 1;
        for (String word : words) {
            char firstChar = word.charAt(0);
            int n = word.length();
            var curGoatLatinWord = new StringBuilder();
            if (vowelSet.contains(firstChar)) {
                curGoatLatinWord.append(word);
            } else {
                curGoatLatinWord.append(word.substring(1, n));
                curGoatLatinWord.append(firstChar);
            }
            curGoatLatinWord.append("ma");
            for (int i = 0; i < wordIndex; i++) {
                curGoatLatinWord.append('a');
            }
            result.append(curGoatLatinWord.toString());
            result.append(' ');
            wordIndex++;
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
