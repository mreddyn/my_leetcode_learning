package com.leetcode_daily_challenge;

import java.util.Arrays;
import java.util.Comparator;

public class SortTheJumbledNumbers {
    private Pair[] numIndexPairs;
    private int pairIndex;

    public int[] sortJumbled(int[] mapping, int[] nums) {
        /*
         * Create a Pair class to store the mapped number and its index.
         * The mapped number is calculated by converting into a char array.
         * After calculating all mapped number sort them based on increasing order.
         * And Create a new array to store the nums based on mapped number indices.
         */
        int n = nums.length;
        numIndexPairs = new Pair[n];
        pairIndex = 0;
        for (int num : nums) {
            mapTheNumber(num, mapping);
            pairIndex++;
        }

        Comparator<Pair> customComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair pairOne, Pair pairTwo) {
                /*
                 * Elements with the same mapped values should appear in the same relative order
                 * as in the input.
                 * The elements of nums should only be sorted based on their mapped values and
                 * not be replaced by them.
                 */
                if (pairOne.number == pairTwo.number) {
                    return 0;
                } else if (pairOne.number < pairTwo.number) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Arrays.sort(numIndexPairs, customComparator);
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = nums[numIndexPairs[i].index];
        }
        return answer;
    }

    private void mapTheNumber(int num, int[] mapping) {
        int mappedNumber = 0;
        char[] numStr = String.valueOf(num).toCharArray();
        for (int i = 0; i < numStr.length; i++) {
            int digit = numStr[i] - '0';
            int mappedDigit = mapping[digit];
            numStr[i] = (char) (mappedDigit + '0');
        }
        mappedNumber = Integer.parseInt(new String(numStr));
        numIndexPairs[pairIndex] = new Pair(mappedNumber, pairIndex);
    }

    class Pair {
        int number;
        int index;

        Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }
}
