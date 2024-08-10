package com.company.amazon.leetcode.easy;

import java.util.Arrays;

public class DecompressRunLengthEncodedList {
    public int[] decompressRLEList(int[] nums) {
        int decompressedListSize = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            decompressedListSize += nums[i];
        }
        int[] decompressedList = new int[decompressedListSize];
        int index = 0;
        for (int i = 1; i < nums.length; i += 2) {
            int frequency = nums[i - 1];
            int val = nums[i];
            Arrays.fill(decompressedList, index, index + frequency, val);
            index += frequency;
        }
        return decompressedList;
    }
}
