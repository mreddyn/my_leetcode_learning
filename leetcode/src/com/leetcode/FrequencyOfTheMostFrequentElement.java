package com.leetcode;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    private int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        long sum = 0;
        int maxFreq = 0;
        while (right < n) {
            sum += nums[right];
            while (sum + k < (long) nums[right] * (right - left + 1)) {
                sum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
            right++;
        }
        return maxFreq;
    }

    public static void main(String[] args) {
        FrequencyOfTheMostFrequentElement frequencyOfTheMostFrequentElement = new FrequencyOfTheMostFrequentElement();
        int[] nums = { 9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990,
                9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000,
                9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981,
                9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926,
                9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946,
                9966 };
        int k = 3056;
        System.out.println(frequencyOfTheMostFrequentElement.maxFrequency(nums, k));
    }
}
