package com.leetcode_daily_challenge;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] extendedFlowerBed = new int[flowerbed.length + 2];
        for(int index = 0; index < flowerbed.length; index++){
            extendedFlowerBed[index+1] = flowerbed[index];
        }
        int prev;
        int cur;
        int next;
        for(int index = 1; index <= flowerbed.length ;index++){
            prev = extendedFlowerBed[index - 1];
            cur = extendedFlowerBed[index];
            next = extendedFlowerBed[index+1];
            if(prev == 0 && cur == 0 && next == 0){
                extendedFlowerBed[index] = 1;
                n--;
            }
        }
        return n <= 0;
    }
    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{ 1, 0, 0, 0, 1, 0, 0}, 2));
    }
}
