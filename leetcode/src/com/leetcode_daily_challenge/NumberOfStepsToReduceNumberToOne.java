package com.leetcode_daily_challenge;

public class NumberOfStepsToReduceNumberToOne {
    private int numSteps(String s) {
        int steps = 0, n = s.length(), carry = 0;
        // if last char is 1 then it is odd number so add 1
        // if last char is zero then it is even, so divide by 2 (right shift by 1 bit)
        for (int i = n - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps++;
            }
        }
        return steps + carry;
    }

    public static void main(String[] args) {
        NumberOfStepsToReduceNumberToOne numberToOne = new NumberOfStepsToReduceNumberToOne();
        System.out.println(numberToOne.numSteps("1101"));
    }
}
