package com.leetcode;

public class MaximumSwap {
    private int maximumSwap(int num) {
        int[] digitIndex = new int[10];
        char[] charNum = String.valueOf(num).toCharArray();
        for (int i = 0; i < charNum.length; i++) {
            digitIndex[charNum[i] - '0'] = i;
        }
        for (int i = 0; i < charNum.length; i++) {
            for (int k = 9; k > charNum[i] - '0'; k--) {
                if (digitIndex[k] > i) {
                    char temp = charNum[i];
                    charNum[i] = charNum[digitIndex[k]];
                    charNum[digitIndex[k]] = temp;
                    return Integer.valueOf(new String(charNum));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(2736));
    }
}
