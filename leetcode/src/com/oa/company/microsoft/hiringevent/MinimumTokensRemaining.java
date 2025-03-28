package com.oa.company.microsoft.hiringevent;

public class MinimumTokensRemaining {
    public int minimumTokensRemaining(int[] arr) {
        int n = arr.length;
        int res = 0; // sum of all remaining tokens
        int carry = 0; // carry from previous iteration

        for (int i = 0; i < n; i++) {
            int tokens = arr[i] + carry;
            arr[i] = tokens % 2;
            carry = tokens / 2;
            res += arr[i];
        }

        while (carry > 0) {
            res += carry % 2;
            carry /= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        var obj = new MinimumTokensRemaining();
        System.out.println(obj.minimumTokensRemaining(new int[] { 2, 3 }));
    }
}
