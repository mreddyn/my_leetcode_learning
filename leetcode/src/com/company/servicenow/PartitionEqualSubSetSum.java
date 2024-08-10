package com.company.servicenow;

public class PartitionEqualSubSetSum {
    private Boolean[][] memo;

    private boolean canPartition(int[] nums) {
        int sum, n;
        n = nums.length;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        sum = sum / 2;
        memo = new Boolean[n + 1][sum + 1];

        return helper(nums, 0, sum);
    }

    private boolean helper(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index == nums.length) {
            return false;
        }

        if (memo[index][sum] != null) {
            return memo[index][sum];
        }

        boolean res = helper(nums, index + 1, sum - nums[index]) || helper(nums, index + 1, sum);
        memo[index][sum] = res;
        return res;
    }

    

    public static void main(String[] args) {
        PartitionEqualSubSetSum partitionEqualSubSetSum = new PartitionEqualSubSetSum();
        System.out.println(partitionEqualSubSetSum.canPartition(new int[] { 1, 5, 11, 5 }));
    }
}
