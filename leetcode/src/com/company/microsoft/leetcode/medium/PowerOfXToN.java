package com.company.microsoft.leetcode.medium;

public class PowerOfXToN {
    public double myPow(double x, int n) {
        /*
         * N = 9 = 2^3 + 2^0 = 1001 in binary. Then:
         * 
         * x^9 = x^(2^3) * x^(2^0)
         * 
         * We can see that every time we encounter a 1 in the binary representation of
         * N, we need to multiply the answer with x^(2^i) where i is the ith bit of the
         * exponent. Thus, we can keep a running total of repeatedly squaring x - (x,
         * x^2, x^4, x^8, etc) and multiply it by the answer when we see a 1.
         */
        long absN = Math.abs((long) n);
        double pow = 1;
        while (absN > 0) {
            if ((absN & 1) == 1) {
                pow = pow * x;
            }
            absN = absN >> 1;
            x = x * x;
        }

        return n < 0 ? 1 / pow : pow;
    }
}
