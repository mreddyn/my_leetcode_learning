package com.leetcode.easy;

import java.util.HashMap;

public class NumberOfBeautifulPairs {
    public int countBeautifulPairs(int[] nums) {
        int beautifulPairsCount = 0, n = nums.length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int num : nums) {
            int firstDigit = getFirstDigit(num);
            int lastDigit = getLastDigit(num);
            if (!map.containsKey(num)) {
                map.put(num, new int[] { firstDigit, lastDigit });
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int xFirstDigit = map.get(nums[i])[0];
                int yLastDigit = map.get(nums[j])[1];
                if (gcd(xFirstDigit, yLastDigit) == 1) {
                    beautifulPairsCount++;
                }
            }
        }
        return beautifulPairsCount;
    }

    private int getFirstDigit(int num) {
        while (num >= 10) {
            num = num / 10;
        }
        return num;
    }

    private int getLastDigit(int num) {
        return num % 10;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public int countBeautifulPairsApproachTwo(int[] nums) {
        /*
         * This is a great approach using a count array and the gcd function to solve
         * the problem in a less complex manner. Let's go through the function step by
         * step.
         * 
         * int cnt[10] = {} initializes an array of size 10 with all elements being 0.
         * The index of this array corresponds to the first digit of the numbers in
         * nums.
         * 
         * res is the result, which counts the number of beautiful pairs.
         * 
         * We start iterating over the nums array. For each number, we do the following:
         * 
         * In the inner loop for (int n = 1; n < 10; ++n), we iterate through 1 to 9
         * (all possible first digits). We then check if n and the last digit of the
         * current number (nums[i] % 10) are coprime (i.e., gcd(n, nums[i] % 10) == 1).
         * If they are, we add the count of n from the count array to res. This means
         * that for each n which is coprime with the last digit of nums[i], we add the
         * number of such n that we have encountered so far (since those would form a
         * beautiful pair with the current number).
         * 
         * The next step (while (nums[i] >= 10) nums[i] /= 10;) is to extract the first
         * digit of the current number nums[i]. We do this by continuously dividing
         * nums[i] by 10 until it is less than 10. Then the value of nums[i] is the
         * first digit of the original number.
         * 
         * We then increment the count of this first digit in the count array
         * (++cnt[nums[i]];), so we remember how many numbers have this first digit.
         * 
         * We continue this process for all the numbers in nums. In the end, res will be
         * the total number of beautiful pairs in nums.
         * 
         * By using this approach, the algorithm goes through the nums array only once,
         * counting the beautiful pairs on the go. This makes the time complexity linear
         * (O(n)), which is more efficient compared to the brute-force approach
         */
        int beautifulPairsCount = 0, n = nums.length;


        return beautifulPairsCount;
    }
}
