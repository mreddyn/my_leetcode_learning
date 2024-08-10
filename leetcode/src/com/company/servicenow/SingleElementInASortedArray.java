package com.company.servicenow;

public class SingleElementInASortedArray {
    private int singleNonDuplicate(int[] nums) {
        int ele = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ele = ele ^ nums[i];
        }
        return ele;
    }

    private int singleNonDuplicateApproachTwo(int[] nums) {
        int low, high;
        low = 0;
        high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                mid = low + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        SingleElementInASortedArray singleElementInASortedArray = new SingleElementInASortedArray();
        System.out.println(singleElementInASortedArray.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
        System.out.println(
                singleElementInASortedArray.singleNonDuplicateApproachTwo(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
    }
}
