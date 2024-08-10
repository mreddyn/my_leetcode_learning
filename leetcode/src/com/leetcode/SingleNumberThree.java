package com.leetcode;

import java.util.HashSet;
import java.util.Iterator;

public class SingleNumberThree {
    private int[] singleNumber(int[] nums) {
        int[] singleNumbers = new int[2];
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                seen.remove(nums[i]);
                continue;
            }
            seen.add(nums[i]);
        }
        Iterator<Integer> iterator = seen.iterator();
        singleNumbers[0] = iterator.next();
        singleNumbers[1] = iterator.next();
        return singleNumbers;
    }

    private int[] singleNumberApproachTwo(int[] nums) {
        int bitmask = 0, n = nums.length;
        // find xor of all elements in nums, we will get two single numbers (x and y)
        // (xor of a^a=0)
        for (int i = 0; i < n; i++) {
            bitmask ^= nums[i];
        }
        // find the rightmost 1-bit diff
        int diff = bitmask & (-bitmask);
        System.out.println(bitmask + " " + diff);
        // bitmask which will only contain x
        int firstSingleNumber = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & diff) != 0) {
                firstSingleNumber ^= nums[i];
            }
        }
        int secondSingleNumber = bitmask ^ firstSingleNumber;
        return new int[] { firstSingleNumber, secondSingleNumber };
    }

    public static void main(String[] args) {
        SingleNumberThree singleNumberThree = new SingleNumberThree();
        System.out.println(singleNumberThree.singleNumber(new int[] { -1, 0 }));
        System.out.println(singleNumberThree.singleNumberApproachTwo(new int[] { 1, 2, 1, 3, 2, 5 }));
    }
}
