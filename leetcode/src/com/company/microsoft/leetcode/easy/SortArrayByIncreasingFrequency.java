package com.company.microsoft.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int n = freqMap.size(), pairIndex = 0;
        Pair[] numFreqPairs = new Pair[n];
        for (int key : freqMap.keySet()) {
            int value = freqMap.get(key);
            numFreqPairs[pairIndex++] = new Pair(key, value);
        }
        Comparator<Pair> customComparator = new Comparator<Pair>() {
            @Override
            public int compare(Pair pairOne, Pair pairTwo) {
                // if frequencies are not equal, then sort by increasing frequency
                // if frequencies are equal, then sort by decreasing frequency
                if (pairOne.value != pairTwo.value) {
                    return pairOne.value - pairTwo.value;
                }
                return pairTwo.key - pairOne.key;

            }
        };
        Arrays.sort(numFreqPairs, customComparator);
        int numsIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < numFreqPairs[i].value; j++) {
                nums[numsIndex++] = numFreqPairs[i].key;
            }
        }
        return nums;
    }

    class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
