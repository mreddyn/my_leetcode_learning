package com.oa.company.amazon.second_time;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class FindMaxToBalance {
    public int findMaxToBalance(String s, String kitParentheses, int[] efficiencyRatings) {
        int closingNeeded = 0, openingNeeded = 0;
        var stack = new ArrayDeque<Character>();

        for (char c : s.toCharArray()) {
            if (kitParentheses.indexOf(c) != -1) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        openingNeeded++;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        closingNeeded = stack.size();
        int maxEfficiency = 0;
        var closingEfficiency = new PriorityQueue<Integer>((a, b) -> b - a);
        var openingEfficiency = new PriorityQueue<Integer>((a, b) -> b - a);

        for (int i = 0; i < efficiencyRatings.length; i++) {
            char c = kitParentheses.charAt(i);
            if (c == '(') {
                openingEfficiency.offer(efficiencyRatings[i]);
            } else {
                closingEfficiency.offer(efficiencyRatings[i]);
            }
        }

        // 3. Use exactly the required number of '(' and ')' to fix the imbalance from s
        for (int i = 0; i < openingNeeded; i++) {
            // If we run out of '(' in the kit, we can't fix s fully (problem states it's
            // always possible)
            if (!openingEfficiency.isEmpty()) {
                maxEfficiency += openingEfficiency.poll();
            }
        }
        for (int i = 0; i < closingNeeded; i++) {
            // If we run out of ')' in the kit, we can't fix s fully
            if (!closingEfficiency.isEmpty()) {
                maxEfficiency += closingEfficiency.poll();
            }
        }

        // 4. Now we can add *extra* matching pairs '(' + ')' if their combined rating >
        // 0
        while (!openingEfficiency.isEmpty() && !closingEfficiency.isEmpty()) {
            int bestOpen = openingEfficiency.peek();
            int bestClose = closingEfficiency.peek();
            int pairSum = bestOpen + bestClose;
            if (pairSum > 0) {
                // Accept both
                maxEfficiency += pairSum;
                openingEfficiency.poll();
                closingEfficiency.poll();
            } else {
                // Because we're in descending order, if the top pair is not profitable,
                // no subsequent pairs will be better as a combination (for these two queues).
                break;
            }
        }

        return maxEfficiency;
    }

    public static void main(String[] args) {
        var findMaxToBalance = new FindMaxToBalance();
        System.out.println(findMaxToBalance.findMaxToBalance("()", "(())", new int[] { 4, 2, -3, -3 }));
        System.out.println(findMaxToBalance.findMaxToBalance(")((", ")(()))", new int[] { 3, 4, 2, -4, -1, -3 }));
    }
}
