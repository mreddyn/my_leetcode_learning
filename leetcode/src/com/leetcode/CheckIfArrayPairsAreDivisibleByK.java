package com.leetcode;

public class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int[] remainderFreqCount = new int[k];
        for (int i = 0; i < n; i++) {
            int remainder = arr[i] % k;
            if (remainder < 0) {
                remainder += k;
            }
            remainderFreqCount[remainder]++;
        }

        if (remainderFreqCount[0] % 2 != 0) {
            // numbers that are divisible by k but are odd in number
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            // if k=5 and a=1,b=4 then (a+b)%k = 0
            if (remainderFreqCount[i] != remainderFreqCount[k - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfArrayPairsAreDivisibleByK cArrayPairsAreDivisibleByK = new CheckIfArrayPairsAreDivisibleByK();
        System.out.println(cArrayPairsAreDivisibleByK.canArrange(new int[] { -1, 1, -2, 2, -3, 3, -4, 4 }, 3));
    }
}
