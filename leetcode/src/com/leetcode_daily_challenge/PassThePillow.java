package com.leetcode_daily_challenge;

public class PassThePillow {
    public int passThePillow(int n, int time) {
        /*
         * Take two pointers (index and direction).
         * index to keep track of the current position, and direction to keep in which
         * direction we need
         * to pass the pillow
         * When the pillow reaches n then shift direction, when pillow reaches 1 then
         * shift direction
         */
        int direction = 0, index = 1;
        while (time > 0) {
            if (direction == 0) {
                index++;
            } else {
                index--;
            }
            if (index == n) {
                direction = 1;
            }
            if (index == 1) {
                direction = 0;
            }
            time--;
        }
        return index;
    }

    public int passThePillowApproachTwo(int n, int time) {
        /*
         * for n people, each round (from one end to the other) needs n-1 times of
         * passing
         * Last round direction:
         * Left to right: k th pass will put the pillow at index: k+1
         * think about it, 1 pass put you at index 2 (1 -> 2), index starts from 1 here
         * Right to left: k th pass will put the pillow at index: n-k
         * last person's index is n, 1 pass will put pillow at index: n -> n-1
         */
        int totalRounds = time / (n - 1);
        int lastRound = time % (n - 1);
        return totalRounds % 2 == 0 ? lastRound + 1 : n - lastRound;
    }

    public static void main(String[] args) {
        PassThePillow passThePillow = new PassThePillow();
        System.out.println(passThePillow.passThePillow(4, 5));
        System.out.println(passThePillow.passThePillow(3, 2));
        System.out.println(passThePillow.passThePillow(4, 6));
    }
}
