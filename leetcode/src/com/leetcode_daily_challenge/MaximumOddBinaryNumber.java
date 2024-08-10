package com.leetcode_daily_challenge;

public class MaximumOddBinaryNumber {
    private String maximumOddBinaryNumber(String s) {
        int size = s.length();
        int numberOfOnes = 0;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '1') {
                numberOfOnes++;

            }
        }
        char ch[] = s.toCharArray();
        int index = 0;
        while (numberOfOnes > 1) {
            ch[index++] = '1';
            numberOfOnes--;
        }
        while (index < size - 1) {
            ch[index++] = '0';
        }
        ch[size - 1] = '1';
        return new String(ch);
    }

    public static void main(String[] args) {
        MaximumOddBinaryNumber maximumOddBinaryNumber = new MaximumOddBinaryNumber();
        String s = "0101";
        System.out.println(maximumOddBinaryNumber.maximumOddBinaryNumber(s));

    }

}
