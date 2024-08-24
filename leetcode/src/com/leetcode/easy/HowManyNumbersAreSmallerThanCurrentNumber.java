package com.leetcode.easy;

public class HowManyNumbersAreSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        /*
         * To check the number of numbers that are smaller than current number we can
         * just sort the
         * nums (in a new array) and count the numbers before it.
         * To simplify it, we will maintain a count array of size 101 which keeps track
         * of frequency of each number.
         * By iterating through the count array we will know how many numbers are there
         * before the current number.
         * We will update this smallerNumbers to count[i].
         * Finally to get the answer we will just get the count[nums[i]]
         */
        int n = nums.length;
        int[] answer = new int[n];
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }

        int smallerNumbers = 0, prev = 0;
        for (int i = 0; i < 101; i++) {
            prev = count[i];
            count[i] = smallerNumbers;
            smallerNumbers += prev;
        }

        for (int i = 0; i < n; i++) {
            answer[i] = count[nums[i]];
        }

        return answer;
    }

    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanCurrentNumber hNumber = new HowManyNumbersAreSmallerThanCurrentNumber();
        hNumber.smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 });
    }
}
