package com.company.amazon.leetcode.medium;

public class SumOfSubArrayMinimums {
    public int sumSubArrayMins(int[] arr) {
        int n = arr.length;
        long sumOfSubArraysMinimum = 0, MOD = (long) (1e9+7);
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            int leftMostIndex = getLeftmostIndexOfElementGreaterThanCurrentElement(arr, element, i);
            int rightMostIndex = getRightMostIndexOfElementGreaterThanCurrentElement(arr, element, i);
            int elementsToTheLeft = i - leftMostIndex;
            int elementsToTheRight = rightMostIndex - i;
            int totalSubArrays = (elementsToTheLeft + 1) * (elementsToTheRight + 1);
            sumOfSubArraysMinimum += totalSubArrays * element;
            System.out.println("Left and Right indices " + leftMostIndex + " " + rightMostIndex);
        }

        return (int) (sumOfSubArraysMinimum % MOD);
    }

    private int getLeftmostIndexOfElementGreaterThanCurrentElement(int[] arr, int element, int index) {
        int leftMostIndex = index;
        for (int i = index - 1; i >= 0; i--) {
            if (element <= arr[i]) {
                leftMostIndex = i;
                continue;
            } else {
                break;
            }
        }
        return leftMostIndex;
    }

    private int getRightMostIndexOfElementGreaterThanCurrentElement(int[] arr, int element, int index) {
        int rightMostIndex = index;
        for (int i = index + 1; i < arr.length; i++) {
            if (element <= arr[i]) {
                rightMostIndex = i;
                continue;
            } else {
                break;
            }
        }
        return rightMostIndex;
    }

    public static void main(String[] args) {
        SumOfSubArrayMinimums sArrayMinimums = new SumOfSubArrayMinimums();
        System.out.println(sArrayMinimums.sumSubArrayMins(new int[] { 71, 55, 82, 55 }));
    }
}
