package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        /*
         * Copy arr into a new array (result) and sort it.
         * Maintain a hashmap to store the number and its rank.
         * Iterate through the result and insert into Hashmap whenever the hashmap does
         * not contain it.
         * rankMap.put(num, rankMap.size()+1).
         * Now iterate through the arr and insert the rank of arr[i] into result array
         */
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rankIndex = 1;
        for (int num : result) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rankIndex++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        return result;
    }
}
