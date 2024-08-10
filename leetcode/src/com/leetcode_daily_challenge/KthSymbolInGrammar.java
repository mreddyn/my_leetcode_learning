package com.leetcode_daily_challenge;

public class KthSymbolInGrammar {
    private int kthGrammar(int n, int k) {
        int totalElementsInNthRow = (int) Math.pow(2, n - 1);
        boolean isKthElementInFirstHalf = true;
        while (totalElementsInNthRow > 1) {
            if (k > totalElementsInNthRow / 2) {
                k -= totalElementsInNthRow / 2;
                isKthElementInFirstHalf = !isKthElementInFirstHalf;
            }
            totalElementsInNthRow /= 2;
        }

        return isKthElementInFirstHalf ? 0 : 1;
    }

    public static void main(String[] args) {
        KthSymbolInGrammar kthSymbolInGrammar = new KthSymbolInGrammar();
        System.out.println(kthSymbolInGrammar.kthGrammar(5, 5));
    }
}
