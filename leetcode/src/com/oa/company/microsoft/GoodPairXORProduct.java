package com.oa.company.microsoft;

import java.io.*;

public class GoodPairXORProduct {
    // Define the modulo constant
    static final int MOD = 1000000007;

    /**
     * Computes (base^exponent) % mod using binary exponentiation.
     *
     * @param base     The base of the exponentiation.
     * @param exponent The exponent.
     * @param mod      The modulo value.
     * @return The result of (base^exponent) % mod.
     */
    static long power(long base, long exponent, int mod) {
        long result = 1;
        base %= mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1) { // If the least significant bit is 1
                result = (result * base) % mod;
            }
            base = (base * base) % mod; // Square the base
            exponent >>= 1; // Shift exponent right by 1 bit
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        int[] A = { 1, 2, 3, 7 };

        // Step 1: Count frequencies of each number in A
        // Since 1 <= A[i] <= 3000, we can use an array of size 3001
        int MAX_A = 3000;
        int[] freq = new int[MAX_A + 1];
        for (int num : A) {
            freq[num]++;
        }

        // Step 2: Calculate frequencies of XOR results
        // The maximum possible XOR value for A[i] <= 3000 is 4095 (12 bits)
        long[] xorCount = new long[4096];
        for (int a = 1; a <= MAX_A; a++) {
            if (freq[a] == 0)
                continue; // Skip if 'a' does not exist in A
            for (int b = a; b <= MAX_A; b++) {
                if (freq[b] == 0)
                    continue; // Skip if 'b' does not exist in A
                int xor = a ^ b;
                if (a == b) {
                    // Number of pairs when a == b: C(freq[a], 2) = freq[a]*(freq[a]-1)/2
                    xorCount[xor] += ((long) freq[a] * (freq[a] - 1)) / 2;
                } else {
                    // Number of pairs when a != b: freq[a] * freq[b]
                    xorCount[xor] += ((long) freq[a] * freq[b]);
                }
            }
        }

        // Step 3: Check for any XOR result of 0
        boolean hasZeroXOR = xorCount[0] > 0;

        if (hasZeroXOR) {
            // If any XOR result is 0, the entire product becomes 0
            System.out.println(0);
        }

        // Step 4: Compute the final product
        long product = 1;
        for (int k = 1; k < xorCount.length; k++) {
            if (xorCount[k] > 0) {
                // Multiply the product by (k^count[k]) % MOD
                product = (product * power(k, xorCount[k], MOD)) % MOD;
            }
        }

        // Output the result for this test case
        System.out.println(product);
    }
}
