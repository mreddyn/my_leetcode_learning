package com.leetcode.easy;

import java.util.Arrays;

public class NumberOfEmployeesWhoMetTheTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        Arrays.sort(hours);
        int n = hours.length, left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (hours[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
            
        }
        return n - left;
    }

    public int numberOfEmployeesWhoMetTargetApproachTwo(int[] hours, int target) {
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfEmployeesWhoMetTheTarget nTarget = new NumberOfEmployeesWhoMetTheTarget();
        System.out.println(nTarget.numberOfEmployeesWhoMetTarget(new int[] { 1, 1, 2, 3, 4 }, 0));
        System.out.println(nTarget.numberOfEmployeesWhoMetTarget(new int[] { 5, 1, 4, 2, 2 }, 6));
        System.out.println(nTarget.numberOfEmployeesWhoMetTarget(new int[] { 15, 43, 21 }, 29));
    }
}
