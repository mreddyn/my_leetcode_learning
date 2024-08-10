package com.leetcode_daily_challenge;

import java.util.HashMap;
import java.util.Map;

public class FindTheIndexOfFirstOccurrenceInString {
    public int strStr(String haystack, String needle) {
        int haystackLength, needleLength;
        haystackLength = haystack.length();
        needleLength = needle.length();
        Map<String, Integer> needleOccurrenceMap = new HashMap<>();
        for(int index = 0; index <= haystackLength - needleLength; index++) {
            int startIndex = index;
            int endIndex = index + needleLength;
            String s = haystack.substring(startIndex, endIndex);
            if(needleOccurrenceMap.containsKey(s)){
                continue;
            }
            needleOccurrenceMap.put(s, index);
        }
        System.out.println(needleOccurrenceMap);
        return needleOccurrenceMap.getOrDefault(needle, -1);
    }

    public static void main(String[] args) {
        System.out.println(new FindTheIndexOfFirstOccurrenceInString().strStr("sadbutsad", "sad"));
        System.out.println(new FindTheIndexOfFirstOccurrenceInString().strStr("leetcode", "leeto"));
    }
}
