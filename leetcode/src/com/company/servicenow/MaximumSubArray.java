package com.company.servicenow;

public class MaximumSubArray {
    private static int maxSubArray(int[] nums) {
        int n = nums.length;
        int dp, maxSum;
        maxSum = nums[0];
        dp = 0;
        for (int i = 0; i < n; i++) {
            dp += nums[i];
            maxSum = Math.max(maxSum, dp);
            if (dp < 0) {
                dp = 0;
            }
        }
        return maxSum;
    }

    private static int[] maxSubArrayIndices(int[] nums) {
        int[] indices = new int[2];
        int maxSoFar = nums[0];
        int curMax = nums[0];
        int start = 0;
        int globalStart = 0;
        int n = nums.length;
        int end = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i] + curMax) {
                curMax = nums[i];
                start = i;
            } else if (nums[i] < curMax + nums[i]) {
                curMax = nums[i] + curMax;
            }
            if (curMax > maxSoFar) {
                maxSoFar = curMax;
                end = i;
                globalStart = start;
            }
        }
        indices[0] = globalStart;
        indices[1] = end;
        return indices;
    }

    public static void main(String[] args) {
        int sum = maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println(sum);
        int[] indices = maxSubArrayIndices(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println(indices[0] + " " + indices[1]);
    }
}
