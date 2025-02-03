package com.oa.company.microsoft;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimizeDifferenceBetweenTwoNumbers {
    public int minimizeDifference(String S, String T) {
        int N = S.length();
        // Compare S and T to determine D's sign
        int D_sign = 0; // 0: equal, 1: S > T, -1: S < T
        for (int i = 0; i < N; i++) {
            char sChar = S.charAt(i);
            char tChar = T.charAt(i);
            if (sChar > tChar) {
                D_sign = 1;
                break;
            } else if (sChar < tChar) {
                D_sign = -1;
                break;
            }
        }

        if (D_sign == 0) {
            return 0; // S and T are already equal
        }

        // Collect all beneficial swaps
        List<Swap> beneficialSwaps = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char sChar = S.charAt(i);
            char tChar = T.charAt(i);
            if (D_sign > 0 && sChar > tChar) {
                int diff = sChar - tChar;
                // To prevent integer overflow, cap the delta to a manageable value
                // Since 2 * diff * 10^(N-1-i) can be very large, use BigInteger for accurate
                // comparison
                // However, for sorting, since higher positions have larger impact, sorting by i
                // ascending suffices
                beneficialSwaps.add(new Swap(i, diff));
            } else if (D_sign < 0 && sChar < tChar) {
                int diff = tChar - sChar;
                beneficialSwaps.add(new Swap(i, diff));
            }
        }

        // Sort the swaps in descending order of impact (higher |delta_i| first)
        // Since |delta_i| = 2 * diff * 10^(N-1-i), and 10^(N-1-i) decreases as i
        // increases,
        // sorting by i ascending ensures higher impact first
        Collections.sort(beneficialSwaps);

        // Calculate the initial difference D
        // Use BigInteger for handling large differences
        BigInteger D;
        if (D_sign > 0) {
            D = new BigInteger(S).subtract(new BigInteger(T));
        } else {
            D = new BigInteger(T).subtract(new BigInteger(S));
        }

        // Initialize swap count
        int swapCount = 0;

        // Iterate through the sorted beneficial swaps
        for (Swap swap : beneficialSwaps) {
            if (D.signum() == 0) {
                break; // Difference is already zero
            }

            // Calculate delta_i = 2 * diff * 10^(N-1-i)
            // Using BigInteger for delta_i
            int diff = swap.delta;
            // Compute 2 * diff
            BigInteger twoDiff = BigInteger.valueOf(2L).multiply(BigInteger.valueOf(diff));

            // Compute 10^(N-1-i)
            int exponent = N - 1 - swap.index;
            BigInteger placeValue = BigInteger.TEN.pow(exponent);

            // Compute |delta_i|
            BigInteger delta_i = twoDiff.multiply(placeValue).abs();

            // Check if |delta_i| <= D
            if (delta_i.compareTo(D) <= 0) {
                // Perform the swap: reduce D by delta_i
                D = D.subtract(delta_i);
                swapCount++;

                // If D <=0, no further swaps needed
                if (D.signum() <= 0) {
                    break;
                }
            }
        }

        return swapCount;
    }

    class Swap implements Comparable<Swap> {
        int index;
        int delta; // |delta_i| = 2 * |S[i] - T[i]| * 10^(N-1-i)

        Swap(int index, int delta) {
            this.index = index;
            this.delta = delta;
        }

        // Sort in descending order of delta (higher impact first)
        public int compareTo(Swap other) {
            return Integer.compare(other.delta, this.delta);
        }
    }

    public static void main(String[] args) {
        MinimizeDifferenceBetweenTwoNumbers obj = new MinimizeDifferenceBetweenTwoNumbers();
        System.out.println(obj.minimizeDifference("29162", "10524")); // should be 2
    }
}
