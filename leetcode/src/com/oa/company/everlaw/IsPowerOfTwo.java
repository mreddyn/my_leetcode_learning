package com.oa.company.everlaw;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    // For testing purposes
    public static void main(String[] args) {
        IsPowerOfTwo solution = new IsPowerOfTwo();
        System.out.println(solution.isPowerOfTwo(1)); // Expected true
        System.out.println(solution.isPowerOfTwo(16)); // Expected true
        System.out.println(solution.isPowerOfTwo(218)); // Expected false
    }
}
