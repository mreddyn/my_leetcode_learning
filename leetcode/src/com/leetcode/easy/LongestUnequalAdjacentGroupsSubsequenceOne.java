package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceOne {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        /*
         * Maintain a flag initially with -1, iterate through the groups array and check
         * if groups[i] != flag
         * and add update the flag value with groups[i] and add the corresponding word
         * to list.
         */
        List<String> subSequenceList = new ArrayList<>();
        int flag = -1;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != flag) {
                flag = groups[i];
                subSequenceList.add(words[i]);
            }
        }

        return subSequenceList;
    }
}
