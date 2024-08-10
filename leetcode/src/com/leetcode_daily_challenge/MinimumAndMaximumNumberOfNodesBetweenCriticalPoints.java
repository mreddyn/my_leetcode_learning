package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class MinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[] { -1, -1 };
        /*
         * if the number of nodes are less then 3 then return {-1, -1}.
         * Maintain three pointers (prev, cur, and next) which point to previous,
         * current, and next nodes.
         * At any point of time if the cur node value is local minimum or local maximum
         * then add its index to list
         * Finally after traversing for maximum distance last index - first index
         * and for minimum distance it is to check the minDiff of two indices
         */
        ListNode prev, cur, next;
        int index = 1;
        List<Integer> criticalPointsIndices = new ArrayList<>();
        prev = head;
        cur = head.next;
        next = (head.next.next != null) ? head.next.next : null;
        if (next == null) {
            return result;
        }
        while (next != null) {
            // check for local minimum
            if (cur.val < prev.val && cur.val < next.val) {
                criticalPointsIndices.add(index);
            }
            // check for local maximum
            else if (cur.val > prev.val && cur.val > next.val) {
                criticalPointsIndices.add(index);
            }
            prev = cur;
            cur = next;
            next = next.next;
            index++;
        }
        int criticalPointsCount = criticalPointsIndices.size();
        if (criticalPointsCount < 2) {
            return result;
        }
        int minimumDistance = Integer.MAX_VALUE;
        for (int i = criticalPointsCount - 1; i > 0; i--) {
            int firstPoint = criticalPointsIndices.get(i);
            int secondPoint = criticalPointsIndices.get(i - 1);
            minimumDistance = Math.min(minimumDistance, firstPoint - secondPoint);
        }
        result[0] = minimumDistance;
        result[1] = criticalPointsIndices.get(criticalPointsCount - 1) - criticalPointsIndices.get(0);
        return result;
    }
}
