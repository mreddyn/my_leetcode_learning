package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length, sum = 0, carry = 1;
        var list = new ArrayList<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            sum = carry;
            sum += digits[i];
            list.add(sum % 10);
            carry = sum / 10;
        }

        if (carry == 1) {
            list.add(1);
        }

        var result = new int[list.size()];
        n = list.size();
        for (int i = 0; i < n; i++) {
            result[n - 1 - i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[] { 1, 2, 3, 4 })));
    }
}
