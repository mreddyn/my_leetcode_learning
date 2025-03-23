package com.oa.company.goldmansachs;

public class MinimumStartValue {
    public long minStart(int[] arr) {
        /*
         * suppose s0 = arr[0]+0, s1 = s0+arr[1], s2 = s1+arr[2], ... sn = s(n-1)+arr[n-1]
         * at any point we need to have sk >= 1, for all k from 0 to n-1
         * if we have sk < 1, then we need to add 1-sk to sk+1
         * so if x is minimum start value then x+sk >= 1
         * then x >= 1-sk
         */
        long runningSum = 0;
        long minPrefixSum = Long.MAX_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            runningSum += arr[i];
            minPrefixSum = Math.min(minPrefixSum, runningSum);
        }

        if (minPrefixSum >= 1) {
            return 1;
        } else {
            return 1 - minPrefixSum;
        }
    }

    public static void main(String[] args) {
        MinimumStartValue obj = new MinimumStartValue();
        int[] arr = { -5, 4, -2, 3, 1, -1, -6, -1, 0, 5 };
        System.out.println(obj.minStart(arr)); // 7
    }
}
