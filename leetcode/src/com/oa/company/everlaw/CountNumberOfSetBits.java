package com.oa.company.everlaw;

public class CountNumberOfSetBits {
    public int countNumberOfSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }

    // For testing purposes
    public static void main(String[] args) {
        CountNumberOfSetBits solution = new CountNumberOfSetBits();
        System.out.println(solution.countNumberOfSetBits(11)); // Expected 3
        System.out.println(solution.countNumberOfSetBits(7)); // Expected 3
    }
}
