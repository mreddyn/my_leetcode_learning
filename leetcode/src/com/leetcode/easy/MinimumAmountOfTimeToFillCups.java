package com.leetcode.easy;

import java.util.PriorityQueue;

public class MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        int timeRequired = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> (b - a));
        for (int cup : amount) {
            if (cup == 0) {
                continue;
            }
            pQueue.add(cup);
        }

        while (!pQueue.isEmpty()) {
            int size = pQueue.size();
            if (size == 1) {
                timeRequired += pQueue.poll();
                break;
            }

            int firstCup = pQueue.poll();
            int secondCup = pQueue.poll();
            firstCup--;
            secondCup--;
            timeRequired++;
            if (firstCup > 0) {
                pQueue.add(firstCup);
            }
            if (secondCup > 0) {
                pQueue.add(secondCup);
            }
        }

        return timeRequired;
    }

    public int fillCupsApproachTwo(int[] amount) {
        /*
         * Suppose we have [1 , 3, 5]
         * The optimal strategy is always to fill two different cups as long they are
         * available.
         * So we can just distribute the smallest stack optimally between the medium and
         * biggest stacks!
         * In this example - [1 , 3, 5] - adding the smallest stack to the medium will
         * result in [0, 3 + 1, 5] - which doesn't doesn't affect the max, so the answer
         * is max(A) == 5
         * In this example - [3, 4, 4] - distributing the smallest stack between the
         * medium and large optimally - [0, 4 + 1, 4 + 2] is the same as evenly
         * splitting the sum of all cups between the two stacks - which is (sum(A) + 1)
         * // 2, in this case (11 + 1) // 2 == 6
         */
        int n = amount.length, timeRequired = 0;
        int max = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, amount[i]);
            sum += amount[i];
        }

        timeRequired = Math.max(max, (sum + 1) / 2);
        return timeRequired;
    }
}
