package com.leetcode;

public class MinimumMovesToReachTargetScore {
    private int minMoves(int target, int maxDoubles) {
        int moves = 0;
        if (target == 1) {
            return 0;
        }
        if (maxDoubles == 0) {
            return target - 1;
        }
        while (target > 0 && maxDoubles > 0) {
            if (target % 2 == 0) {
                target = target / 2;
                maxDoubles--;
            } else {
                target = target - 1;
            }
            moves++;
        }
        return moves + target - 1;
    }

    public static void main(String[] args) {
        MinimumMovesToReachTargetScore minimumMovesToReachTargetScore = new MinimumMovesToReachTargetScore();
        System.out.println(minimumMovesToReachTargetScore.minMoves(19, 2));
    }
}
