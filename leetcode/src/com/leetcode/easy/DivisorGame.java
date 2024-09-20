package com.leetcode.easy;

public class DivisorGame {
    public boolean divisorGame(int n) {
        /*
         * Odd numbers only have odd divisors, and even numbers have even and odd
         * divisors.
         * if n == 1, the current player loses.
         * if n == 2, current player chooses 1 and next player gets n=1, so they lose.
         * if n == 3, the current will choose 1 and next player gets n=2, and they will
         * choose 1
         * approach :
         * Alice will try to give bob always an odd number .. why ?
         * odd numbers have divisors only odd. So if bob gets only odd number, he is
         * forced to give alice always even number... why?
         * let say bob has an odd number, as odd numbers has divisor only odd
         * number, bob will give odd number - odd divisor = even number to alice
         * in this way alice always get even number and bob always gets odd number
         * at last bob will get 1(odd number) and he looses.
         * 
         * if alice got a even number , she can always give bob a odd number as even
         * numbers have divisor both odd and even ...why ?
         * alice will pick any odd divisor and bob will get even number - odd
         * divisor = odd number
         * if alice got a odd number, she is forced to give bob an even number and
         * bob will always give alice odd number by same above strategy and she will
         * loose.
         * 
         * So our problem will depend on the initial value given to alice, if it is
         * even she will win otherwise not.
         */
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        DivisorGame dGame = new DivisorGame();
        System.out.println(dGame.divisorGame(2));
        System.out.println(dGame.divisorGame(3));
    }
}
