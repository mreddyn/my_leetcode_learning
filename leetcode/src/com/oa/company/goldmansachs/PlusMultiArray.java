package com.oa.company.goldmansachs;

public class PlusMultiArray {
    public String plusMultArray(int[] A) {
        // write your code here
        int n = A.length;
        int odd_sum = 0;
        int x = 0;
        int y = 0;
        int even_sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (x % 2 == 0) {
                    even_sum += A[i];
                    x++;
                } else {
                    even_sum *= A[i];
                    x++;
                }
            } else {
                if (y % 2 == 0) {
                    odd_sum += A[i];
                    y++;
                } else {
                    odd_sum *= A[i];
                    y++;
                }
            }
        }
        x = even_sum % 2;
        y = odd_sum % 2;
        if (x > y) {
            return "EVEN";
        } else if (x < y) {
            return "ODD";
        }
        return "NEUTRAL";
    }

    public static void main(String[] args) {
        PlusMultiArray obj = new PlusMultiArray();
        int[] A = { 12, 3, 5, 7, 13, 12 };
        System.out.println(obj.plusMultArray(A));
    }
}
