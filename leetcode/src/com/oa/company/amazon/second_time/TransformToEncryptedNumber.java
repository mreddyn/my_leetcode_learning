package com.oa.company.amazon.second_time;

import java.util.ArrayList;
import java.util.List;

public class TransformToEncryptedNumber {
    public String encryptNumber(int[] digit_numbers) {
        // Convert the array to a List for easier manipulation.
        List<Integer> curr = new ArrayList<>();
        for (int digit : digit_numbers) {
            curr.add(digit);
        }

        // Continue the process until only 2 digits remain.
        while (curr.size() > 2) {
            List<Integer> next = new ArrayList<>();
            // For every adjacent pair, compute the sum and take the rightmost digit.
            for (int i = 0; i < curr.size() - 1; i++) {
                int sum = curr.get(i) + curr.get(i + 1);
                next.add(sum % 10);
            }
            curr = next;
        }

        // Format the final two digits as a string.
        // If the first digit is 0, it will be preserved in the string.
        return "" + curr.get(0) + curr.get(1);
    }

    // A simple main to test the function.
    public static void main(String[] args) {
        var obj = new TransformToEncryptedNumber();
        int[] digit_numbers = { 4, 5, 6, 7 };
        String result = obj.encryptNumber(digit_numbers);
        System.out.println(result); // Expected output: "04"
    }
}
