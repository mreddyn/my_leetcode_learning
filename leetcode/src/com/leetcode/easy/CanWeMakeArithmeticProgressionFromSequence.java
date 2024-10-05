package com.leetcode.easy;

public class CanWeMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : arr) {
            // find the max and min elements in arr
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int gap = (max - min) / (n - 1);

        if (max - min != gap * (n - 1)) {
            return false;
        }

        // edge case: [1,1,1,1] or [0,0,0,0]
        if (gap == 0 && min == max) {
            return true;
        }

        // For a sequence of elements should be in A.P, it should follow
        // min+0*gap, min+1*gap, min+2*gap, ... min+(n-1)*gap
        for (int i = 0; i < n;) {
            if ((arr[i] - min) % gap != 0) {
                return false;
            }

            int index = (arr[i] - min) / gap;
            if (index == i) {
                // if an element is in correct place then continue;
                i++;
                continue;
            } else {
                // [1,2,2,4], in case of duplicate return false;
                if (arr[index] == arr[i]) {
                    return false;
                }

                // [2,1,3,4] => [1,2,3,4]; swap the elements
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        return true;
    }
}
