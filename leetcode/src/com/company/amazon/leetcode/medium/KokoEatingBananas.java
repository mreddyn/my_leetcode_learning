package com.company.amazon.leetcode.medium;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        /*
         * Given piles=[3,6,7,11] and h=8;
         * for k=11, 3/3, 6/6, 7/7, 11/11 so koko can eat in 4 hrs
         * for k=10, 3/3, 6/6, 7/7, 10/11, 1/11 so koko can eat in 5 hrs
         * for k=9, 3/3, 6/6, 7/7, 9/11, 2/11 so koko can eat in 5 hrs
         * for k=8, 3/3, 6/6, 7/7, 8/11, 3/11 so koko can eat in 5 hrs
         * for k=7, 3/3, 6/6, 7/7, 7/11, 4/11 so koko can eat in 5 hrs
         * for k=6, 3/3, 6/6, 6/7,1/7, 6/11, 5/11 so koko can eat in 6 hrs
         * for k=5, 3/3, 5/6,1/6, 5/7,2/7, 5/11, 5/11, 1/11 so koko can eat in 8 hrs
         * for k=4, 3/3, 4/6,2/6, 4/7,3/7, 4/11, 4/11, 3/11 so koko can eat in 8 hrs
         * 
         * We need to perform binary search to find out minimum eating speed.
         * if koko can eat all piles of bananas under h hours then we decrease k and go
         * left
         * if koko can not eat all piles then we increase k
         */

        int left, right;
        left = 1;
        right = 1000000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canKokoEatAllPiles(piles, h, mid)) {
                // if koko can eat then we travel towards left, to find minimum k
                right = mid - 1;
                continue;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canKokoEatAllPiles(int[] piles, int h, int k) {
        int n = piles.length, hours = 0;
        for (int i = 0; i < n; i++) {
            int curPile = piles[i];
            int div = curPile / k;
            int remainder = curPile % k;
            hours += div;
            if (remainder != 0) {
                hours++;
            }
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        KokoEatingBananas kBananas = new KokoEatingBananas();
        System.out.println(kBananas.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
    }
}
