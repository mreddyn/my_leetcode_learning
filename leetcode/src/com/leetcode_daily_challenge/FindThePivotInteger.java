package com.leetcode_daily_challenge;

public class FindThePivotInteger {
    private int pivotInteger(int n) {
        int leftIndex, rightIndex, leftSum, rightSum, pivot = -1;
        leftSum = leftIndex = 1;
        rightSum = rightIndex = n;
        while (leftIndex <= rightIndex) {
            if (leftSum > rightSum) {
                rightIndex--;
                rightSum += rightIndex;
            } else if (leftSum < rightSum) {
                leftIndex++;
                leftSum += leftIndex;
            } else {
                if (leftIndex == rightIndex) {
                    pivot = leftIndex;
                    break;
                } else {
                    leftIndex++;
                    rightIndex--;
                    rightSum += rightIndex;
                    leftSum += leftIndex;
                }
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
        FindThePivotInteger findThePivotInteger = new FindThePivotInteger();
        System.out.println(findThePivotInteger.pivotInteger(4));
    }
}
