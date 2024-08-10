package com.leetcode;

public class DecodeXORedArray {
    private int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] arr = new int[n + 1];
        arr[0] = first;
        for (int i = 1; i <= n; i++) {
            arr[i] = encoded[i - 1] ^ arr[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        DecodeXORedArray decodeXORedArray = new DecodeXORedArray();
        decodeXORedArray.decode(new int[] { 1, 2, 3 }, 1);
    }
}
