package com.company.rubrik.medium;

public class AliceAndBobPlayingFlowerGame {
    public long flowerGame(int n, int m) {
        /*
         * Alice and Bob start playing with Alice playing first.
         * Whenever a player has no more flowers to choose then that player looses.
         * Since ALice starts, she will loose if there are even number of flowers.
         * Alice can only win if she can pick odd number of flowers.
         * 
         * Given m = 3, n = 2
         * possible ways of picking are [1,1],[1,2],[2,1],[2,2],[3,1],[3,2]
         * So from above example Alice will win for [1,2], [2,1], [3,2]
         * 
         * m*n will give us total number of ways they can pick.
         * m*n/2 will give the total number of ways Alice can win
         */
        long totalWays = ((long) m * (long) n);
        return totalWays / 2;
    }
}
