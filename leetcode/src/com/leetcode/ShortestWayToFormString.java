package com.leetcode;

import java.util.HashSet;

public class ShortestWayToFormString {
    private int shortestWay(String source, String target) {

        // the unique char count should be same for source and destination
        int sourceLength = source.length(), targetLength = target.length();
        HashSet<Character> seen = new HashSet<>();
        // add source chars to set
        for (int i = 0; i < sourceLength; i++) {
            seen.add(source.charAt(i));
        }
        // check for chars which are not in source of target
        for (int i = 0; i < targetLength; i++) {
            if (!seen.contains(target.charAt(i))) {
                return -1;
            }
        }
        int requiredSubsequences = 0, sourceIndex = 0, targetIndex = 0;
        while (targetIndex < targetLength) {
            for (sourceIndex = 0; sourceIndex < sourceLength; sourceIndex++) {
                if (targetIndex < targetLength && source.charAt(sourceIndex) == target.charAt(targetIndex)) {
                    targetIndex++;
                }
            }
            requiredSubsequences++;
        }
        return requiredSubsequences;
    }

    public static void main(String[] args) {
        ShortestWayToFormString sFormString = new ShortestWayToFormString();
        System.out.println(sFormString.shortestWay("xyz", "xzyxz"));
        System.out.println(sFormString.shortestWay("abc", "abcbc"));
        System.out.println(sFormString.shortestWay("aaaaa", "aaaaaaaaaaaa"));
    }
}
