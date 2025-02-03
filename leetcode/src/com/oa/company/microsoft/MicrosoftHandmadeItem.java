package com.oa.company.microsoft;

import java.io.*;

public class MicrosoftHandmadeItem {
    public int microsoftHandmadeItem(int[] T) {
        int N = T.length;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (long) T[i] * (N - i);
            sum %= 1000000000;
        }
        return (int) sum;
    }

    // For testing purposes
    public static void main(String[] args) throws IOException {
        MicrosoftHandmadeItem solution = new MicrosoftHandmadeItem();
        int[] T = { 3, 1, 2 };
        System.out.println(solution.microsoftHandmadeItem(T)); // Expected 13
        int[] T1 = { 1, 2, 3, 4 };
        System.out.println(solution.microsoftHandmadeItem(T1)); // Expected 24
    }
}
