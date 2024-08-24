package com.leetcode.easy;

public class KItemsWithMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        /*
         * if we have k numOnes then we return k.
         * if we do not have enough numOnes then use numZeroes and return numOnes (max
         * possible sum)
         * if we do not have enough numOnes and numZeroes then use numNegOnes and return
         * numOnes - (k-numOnes-numZeroes)
         */
        if (k <= numOnes) {
            return k;
        }
        if (k <= (numOnes + numZeros)) {
            return numOnes;
        }
        return numOnes - (k - numOnes - numZeros);
    }
}
