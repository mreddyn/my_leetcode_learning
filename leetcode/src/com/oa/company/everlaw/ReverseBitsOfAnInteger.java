package com.oa.company.everlaw;

public class ReverseBitsOfAnInteger {
    public int reverseBitsOfAnInteger(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result |= n & 1;
            n >>= 1;
        }
        return result;
    }

    // For testing purposes
    public static void main(String[] args) {
        ReverseBitsOfAnInteger solution = new ReverseBitsOfAnInteger();
        System.out.println(solution.reverseBitsOfAnInteger(43261596)); // Expected 964176192
        System.out.println(solution.reverseBitsOfAnInteger(429496729)); // Expected 3221225471
    }
}
