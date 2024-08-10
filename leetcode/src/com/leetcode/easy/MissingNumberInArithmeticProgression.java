package com.leetcode.easy;

public class MissingNumberInArithmeticProgression {
    public int missingNumber(int[] arr) {
        /*
         * We will find the Diff, and loop through the arr to check for the missing
         * number
         * by adding diff to previous term to see if it equals current term or not.
         */
        int missingNumber = 0, n = arr.length;
        int diff = getDiffOfArithmeticProgression(arr, n);
        if (diff == 0 && arr[0] == 0) {
            return 0;
        }
        if (diff == 0 && arr[0] == 1) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            int nextTerm = arr[i - 1] + diff;
            if (nextTerm != arr[i]) {
                missingNumber = nextTerm;
            }
        }

        return missingNumber;
    }

    private int getDiffOfArithmeticProgression(int[] arr, int n) {
        // lastTerm in a A.P = a+(n-1)*d
        int firstTerm = arr[0], lastTerm = arr[n - 1];
        int diff = (lastTerm - firstTerm) / n;
        return diff;
    }

    public int missingNumberApproachTwo(int[] arr) {
        /*
         * The sum of elements in Arithmetic Progression is (firstTerm + lastTerm) * n/2
         * so Missing number = A.P sum - sum of arr
         */
        int missingNumber = 0, n = arr.length, sum = 0, sumOfAP = 0;
        for (int num : arr) {
            sum += num;
        }
        sumOfAP = (arr[0] + arr[n - 1]) * (n + 1) / 2;
        missingNumber = sumOfAP - sum;
        return missingNumber;
    }

    public int missingNumberApproachThree(int[] arr) {
        /*
         * Since input is sorted we can search for missing number by doing binary search
         */
        int n = arr.length, left = 0, right = n, missingNum = 0, diff = (arr[n - 1] - arr[0]) / n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == arr[0] + diff * mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        missingNum = arr[0] + diff * left;
        return missingNum;
    }
}
