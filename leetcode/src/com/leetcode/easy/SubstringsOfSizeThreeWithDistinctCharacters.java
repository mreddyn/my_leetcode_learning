package com.leetcode.easy;

import java.util.HashMap;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        int goodSubstringsCount = 0, n = s.length();
        if (n < 3) {
            return 0;
        }
        int mid = 0;
        while (++mid < n - 1) {
            char prevChar = s.charAt(mid - 1), midChar = s.charAt(mid), nextChar = s.charAt(mid + 1);
            if (prevChar != midChar && midChar != nextChar && nextChar != prevChar) {
                goodSubstringsCount++;
            }
        }
        return goodSubstringsCount;
    }

    public int countGoodSubstringsSlidingWindowApproach(String s) {
        int goodSubstringsCount = 0, n = s.length(), windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            map.put(s.charAt(windowEnd), map.getOrDefault(s.charAt(windowEnd), 0) + 1);
            if (windowEnd - windowStart + 1 < 3) {
                continue;
            }

            if (map.size() == 3) {
                goodSubstringsCount++;
                map.remove(s.charAt(windowStart));
                windowStart++;
            } else {
                map.put(s.charAt(windowStart), map.get(s.charAt(windowStart)) - 1);
                if (map.get(s.charAt(windowStart)) == 0) {
                    map.remove(s.charAt(windowStart));
                }
                windowStart++;
            }

            System.out.println(map);
        }

        return goodSubstringsCount;
    }

    public static void main(String[] args) {
        SubstringsOfSizeThreeWithDistinctCharacters sCharacters = new SubstringsOfSizeThreeWithDistinctCharacters();
        System.out.println(sCharacters.countGoodSubstringsSlidingWindowApproach("aababcabc"));
        System.out.println(sCharacters.countGoodSubstringsSlidingWindowApproach("owuxoelszb"));
        System.out.println(sCharacters.countGoodSubstringsSlidingWindowApproach("xyzzaz"));
    }
}
