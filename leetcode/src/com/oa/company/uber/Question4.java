package com.oa.company.uber;

public class Question4 {
    private static long solution(int[] a) {
        long count = 0;
        int n;
        n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                count = (helper(a[i], a[j])) ? count + 1 : count;
            }
        }
        return count;
    }

    private static boolean helper(int num1, int num2) {
        String pattern = "" + num1;
        String sequence = "" + num2;
        if(pattern.length() != sequence.length()){
            return false;
        }
        pattern = pattern+""+num1;
        if (pattern.contains(sequence)) { // check for substring of pattern matches with sequence: O(m*n) complexity
            System.out.println("Yes");
            System.out.println("pattern : " + pattern);
            System.out.println("sequence : " + sequence);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int a[] = { 13, 5604, 31, 2, 13, 4560, 546, 654, 456 };
        System.out.println(solution(a));
    }
}
