package com.leetcode.easy;

public class MaximumSixtyNineNumber {
    public int maximum69Number(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        boolean isUpdated = false;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == '6') {
                ch[i] = '9';
                isUpdated = true;
                break;
            }
        }
        if(!isUpdated) {
            return num;
        }

        return Integer.parseInt(new String(ch));
    }
}
