package com.leetcode_daily_challenge;

public class FindUniqueBinaryString {
    private String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] appeared = new int[(int) Math.pow(2, n)];
        int firstMissing = 0;
        for (int index = 0; index < n; index++) {
            appeared[Integer.parseInt(nums[index], 2)] = 1;
        }
        for (int i = 0; i < appeared.length; i++) {
            if (appeared[i] == 0) {
                firstMissing = i;
                break;
            }
        }
        System.out.println(String.format("%" + n + "s", Integer.toBinaryString(firstMissing)));
        return String.format("%" + n + "s", Integer.toBinaryString(firstMissing)).replace(' ', '0');
    }

    public static void main(String[] args) {
        FindUniqueBinaryString findUniqueBinaryString = new FindUniqueBinaryString();
        System.out.println(findUniqueBinaryString.findDifferentBinaryString(new String[] { "111", "011", "001" }));
    }
}
