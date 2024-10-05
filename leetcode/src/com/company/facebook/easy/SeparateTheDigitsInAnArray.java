package com.company.facebook.easy;

import java.util.ArrayList;
import java.util.Collections;

public class SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        var numsDigitsList = new ArrayList<Integer>();
        for (int num : nums) {
            var tempList = new ArrayList<Integer>();
            while (num > 0) {
                int digit = num % 10;
                tempList.add(digit);
                num /= 10;
            }
            Collections.reverse(tempList);

            for (int i = 0; i < tempList.size(); i++) {
                numsDigitsList.add(tempList.get(i));
            }
        }

        return numsDigitsList.stream().mapToInt(i -> i).toArray();
    }

    public int[] separateDigitsApproachTwo(int[] nums) {
        var numsDigitsList = new ArrayList<Integer>();
        for (int num : nums) {
            String s = String.valueOf(num);
            int n = s.length();
            for (int i = 0; i < n; i++) {
                numsDigitsList.add(s.charAt(i) - '0');
            }
        }

        return numsDigitsList.stream().mapToInt(i -> i).toArray();
    }
}
