package com.leetcode.easy;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        /*
         * 
         */
        int n = arr.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        for (int i = n - 2; i >= 0; i--) {
            answer[i] = Math.max(answer[i + 1], arr[i + 1]);
        }
        return answer;
    }
}
