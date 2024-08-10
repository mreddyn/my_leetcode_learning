package com.company.servicenow;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGameTwo {
    private int jump(int[] nums) {
        int n;
        n = nums.length;
        if (n == 1) {
            return 0;
        }
        int level = 0;
        boolean canReach = false;
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(0);
        set.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int index = queue.poll();
                if (index == n - 1) {
                    canReach = true;
                    break;
                }
                if (nums[index] == 0) {
                    continue;
                }

                int furthestJump = Math.min(n - 1, nums[index] + index);
                for (int i = furthestJump; i >= index + 1; i--) {
                    if (set.add(i)) {
                        queue.add(i);
                    }
                    System.out.print(nums[i] + " ");
                }

            }
            level++;
            if (canReach) {
                break;
            }
            System.out.println();
        }
        return level - 1;
    }

    private int jumpApproachTwo(int[] nums) {
        int n;
        n = nums.length;
        if (n == 1) {
            return 0;
        }
        int curEnd, curFar, jumps;
        jumps = 0;
        curEnd = 0;
        curFar = 0;
        for (int i = 0; i < n - 1; i++) {
            curFar = Math.max(curFar, nums[i] + i);
            if (i == curEnd) {
                jumps++;
                curEnd = curFar;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameTwo jumpGameTwo = new JumpGameTwo();
        System.out.println(jumpGameTwo.jump(new int[] { 9, 7, 9, 4, 8, 1, 6, 1, 5, 6, 2, 1, 7, 9, 0 }));
        System.out.println(jumpGameTwo.jumpApproachTwo(new int[] { 9, 7, 9, 4, 8, 1, 6, 1, 5, 6, 2, 1, 7, 9, 0 }));
    }
}
