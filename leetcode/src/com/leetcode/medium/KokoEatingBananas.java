package com.leetcode.medium;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEat(int[] piles, int h, int speed) {
        int hoursCount = 0;
        for (int pile : piles) {
            hoursCount += (pile / speed);
            if (pile % speed != 0) {
                hoursCount++;
            }

            if (hoursCount > h) {
                return false;
            }
        }

        return true;
    }
}
