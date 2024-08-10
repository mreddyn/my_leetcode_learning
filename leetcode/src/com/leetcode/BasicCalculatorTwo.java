package com.leetcode;

import java.util.Stack;

public class BasicCalculatorTwo {
    private static int calculate(String s) {
        int lastDigit;
        lastDigit = 0;
        Stack<Integer> numberStack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ' '){
                continue;
            }
            else if(Character.isDigit(ch)){
                int currentDigit = Character.getNumericValue(ch);
                lastDigit = lastDigit * 10 + currentDigit;
            }
            else{
                
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate("1-1+1"));
        System.out.println(calculate("0-1"));
        System.out.println(calculate("0-2147483647"));
    }
}
