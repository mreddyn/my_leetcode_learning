package com.oa.company.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordPatternTwo {
    private HashMap<Character, String> char_to_word_map;
    private Set<String> usedSubStrings;

    public boolean wordPatternMatch(String pattern, String s) {
        char_to_word_map = new HashMap<>();
        usedSubStrings = new HashSet<>();
        return backtrack(pattern, s, 0, 0);
    }

    private boolean backtrack(String pattern, String s, int pIndex, int sIndex) {

        // if we reached end of pattern and String then we can return true
        if (pIndex == pattern.length()) {
            return sIndex == s.length();
        }

        // current pattern character
        char c = pattern.charAt(pIndex);

        // see if current character in pattern is already mapped
        if (char_to_word_map.containsKey(c)) {
            var mappedStr = char_to_word_map.get(c);

            // check in s if s from sIndex startsWith mappedStr
            if (!s.startsWith(mappedStr, sIndex)) {
                return false;
            }

            // if it matches we can proceed to the next of String
            return backtrack(pattern, s, pIndex + 1, sIndex + mappedStr.length());
        } else {
            // try all possible combinations from sIndex
            for (int cut = sIndex + 1; cut <= s.length(); cut++) {
                var candidate = s.substring(sIndex, cut);

                // if candidate is already used then skip it
                if (usedSubStrings.contains(candidate)) {
                    continue;
                }

                // create new mapping and mark the candidate as used
                char_to_word_map.put(c, candidate);
                usedSubStrings.add(candidate);

                // backtrack
                if (backtrack(pattern, s, pIndex + 1, cut)) {
                    return true;
                }

                // remove mapping
                char_to_word_map.remove(c);
                usedSubStrings.remove(candidate);
            }
        }

        return false;
    }
}
