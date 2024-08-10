package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitWithMinimumSum {
    private List<Integer> digitsList;

    public int splitNum(int num) {
        /*
         * Split the given number into digits (in a ArrayList) and sort them.
         * TO form a two numbers with minimum possible sum then we must take first
         * number from only
         * even indices of digitsList.
         * And the second number from only odd indices.
         */
        int minPossibleSum = 0;
        digitsList = new ArrayList<>();
        convertNumberToDigits(num);
        Collections.sort(digitsList);
        int listSize = digitsList.size(), evenIndex = 0, oddIndex = 1, numOne = 0, numTwo = 0;
        while (evenIndex < listSize) {
            numOne = numOne * 10 + digitsList.get(evenIndex);
            evenIndex += 2;
        }

        while (oddIndex < listSize) {
            numTwo = numTwo * 10 + digitsList.get(oddIndex);
            oddIndex += 2;
        }
        minPossibleSum = numOne + numTwo;
        return minPossibleSum;
    }

    private void convertNumberToDigits(int num) {
        while (num > 0) {
            int remainder = num % 10;
            digitsList.add(remainder);
            num = num / 10;
        }
    }

    public static void main(String[] args) {
        SplitWithMinimumSum sMinimumSum = new SplitWithMinimumSum();
        System.out.println(sMinimumSum.splitNum(4325));
        System.out.println(sMinimumSum.splitNum(687));
        System.out.println(sMinimumSum.splitNum(1097685));
    }
}
