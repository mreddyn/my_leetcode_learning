package com.leetcode.easy;

public class ShortestDistanceToACharacter {

    public int[] shortestToChar(String s, char c) {
        /*
         * Maintain a pointer (position) which keeps track of the position of char c.
         * Loop through the string s from left to right.
         * at every index we find the closest c to the left which is i-position.
         * if we see a char c then record its position.
         * 
         * Now loop through the string from right to left.
         * at every index we find the closest c to the right which is min(answer[i],
         * position-i)
         * if we see a char c then record its position.
         */
        int n = s.length(), position = -n;
        var answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                position = i;
            }
            answer[i] = i - position;
        }

        for (int i = position - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                position = i;
            }
            answer[i] = Math.min(answer[i], position - i);
        }

        return answer;
    }

    public static void main(String[] args) {
        ShortestDistanceToACharacter sACharacter = new ShortestDistanceToACharacter();
        sACharacter.shortestToChar("iloveleetcode", 'e');
    }
}
