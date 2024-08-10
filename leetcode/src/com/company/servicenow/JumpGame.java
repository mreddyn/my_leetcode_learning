package com.company.servicenow;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame {
    private boolean canJump(int[] nums) {
        int n;
        n = nums.length;
        if (n == 1) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean canReach = false;
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int index = queue.poll();
                if (nums[index] == 0) {
                    continue;
                }
                int furthestJump = Math.min(nums[index] + index, n - 1);
                if (furthestJump == n - 1) {
                    canReach = true;
                    break;
                }
                for (int jump = index + 1; jump <= furthestJump; jump++) {
                    queue.add(jump);
                }
            }
        }

        return canReach;
    }

    private boolean canJumpApproachTwo(int[] nums) {
        int n;
        n = nums.length;
        if (n == 1) {
            return true;
        }
        int lastPosition = n - 1;
        for (int index = n - 2; index >= 0; index--) {
            if (index + nums[index] >= lastPosition) {
                lastPosition = index;
            }
        }

        return lastPosition == 0;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(jumpGame.canJumpApproachTwo(new int[] { 2, 3, 1, 1, 4 }));
    }

}
