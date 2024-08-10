package com.company.servicenow;

import java.util.HashMap;

public class SubArraySumEqualsK {
    private int subArraySum(int[] nums, int k) {
        int count = 0, runningSum = 0;
        HashMap<Integer, Integer> sumOccurrenceMap = new HashMap<>();
        sumOccurrenceMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            int complement = runningSum - k;
            if (sumOccurrenceMap.containsKey(complement)) {
                count += sumOccurrenceMap.get(complement);
            }
            sumOccurrenceMap.put(runningSum, sumOccurrenceMap.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        System.out.println(subArraySumEqualsK.subArraySum(new int[] { 3, 4, 7, 2, -3, 1, 4, 2 }, 7));
    }
}
