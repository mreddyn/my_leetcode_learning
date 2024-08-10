package com.leetcode_daily_challenge;

public class UglyNumber {
    private static boolean isUgly(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 1) {
            return false;
        }
        int dividend = keepDividingUntilDivisible(n, 2);
        if(dividend == 1){
            return true;
        }
        dividend = keepDividingUntilDivisible(dividend, 3);
        if(dividend == 1){
            return true;
        }
        dividend = keepDividingUntilDivisible(dividend, 5);
        if(dividend == 1){
            return true;
        }
        return false;
    }
    private static int keepDividingUntilDivisible(int dividend, int divisor){
        while(dividend % divisor == 0){
            dividend = dividend / divisor;
        }
        return dividend;
    }

    private static boolean isUgly_meth_2(int n){
        if(n <= 0){
            return false;
        }
        while(n%2 == 0){
            n = n/2;
        }
        while(n%3 == 0){
            n = n/3;
        }
        while(n%5 == 0){
            n = n/5;
        }
        if(n == 1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
    }
}
