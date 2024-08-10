package com.leetcode_daily_challenge;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums){
        int evenNumberIndex = 0;
        for(int index=0; index< nums.length;index++){
            if(nums[index]%2 == 0){
                int temp = nums[evenNumberIndex];
                nums[evenNumberIndex] = nums[index];
                nums[index] = temp;
                evenNumberIndex++;
            }
        }
        return nums;
    }
}
