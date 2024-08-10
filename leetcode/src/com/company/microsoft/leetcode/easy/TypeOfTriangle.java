package com.company.microsoft.leetcode.easy;

public class TypeOfTriangle {
    public String triangleType(int[] nums) {
        /*
         * TO form a triangle sum of any two sides need to strictly greater than the
         * third side
         *
         */
        int sideOne = nums[0], sideTwo = nums[1], sideThree = nums[2];
        if (sideOne + sideTwo < sideThree || sideOne + sideThree < sideTwo || sideTwo + sideThree < sideOne) {
            return "none";
        }

        if (sideOne == sideTwo && sideTwo == sideThree) {
            return "equilateral";
        } else if (sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
            return "isosceles";
        }

        return "scalene";
    }
}
