package com.leetcode;

public class MinimumFlipsToMakeAOrBEqualToC {
    private int minFlips(int a, int b, int c) {
        int minFlipsCount = 0;
        minFlipsCount = countSetBits(c ^= (a | b)) + countSetBits(a & b & c);
        return minFlipsCount;
    }

    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumFlipsToMakeAOrBEqualToC makeAOrBEqualToC = new MinimumFlipsToMakeAOrBEqualToC();
        System.out.println(makeAOrBEqualToC.minFlips(2, 6, 5));
    }
}
