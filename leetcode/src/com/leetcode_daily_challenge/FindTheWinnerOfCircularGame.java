package com.leetcode_daily_challenge;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfCircularGame {
    public int findTheWinner(int n, int k) {
        // ArrayList (circle) to maintain n friends
        List<Integer> circle = new ArrayList<>();

        // Add n friends to the list (circle)
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        int startIndex = 0;
        while (circle.size() > 1) {
            // calculate the friend index that needs to be deleted
            int remainingFriends = circle.size();
            int removalIndex = (startIndex + k - 1) % remainingFriends;
            circle.remove(removalIndex);
            // update startIndex for next round
            startIndex = removalIndex;
        }
        return circle.get(0);
    }

    public int findTheWinnerQueueApproach(int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            // remove the friends until k-1 and re-add them after removing kth friend
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.remove());
            }

            // remove the kth friend
            queue.remove();
        }
        return queue.peek();
    }
}
