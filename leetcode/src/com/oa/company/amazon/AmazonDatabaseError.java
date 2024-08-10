package com.oa.company.amazon;

import java.util.HashMap;

public class AmazonDatabaseError {
    private int getMinErrors(String errorString, int x, int y) {
        int zeroesBefore, onesBefore, n;
        n = errorString.length();
        zeroesBefore = 0;
        onesBefore = 0;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = errorString.charAt(i);
            if (c == '0') {
                zeroesBefore++;
            } else if (c == '1') {
                onesBefore++;
            }
            map.put(i, new int[] { zeroesBefore, onesBefore });
        }

        int zeroesAfter, onesAfter, errors;
        zeroesAfter = 0;
        onesAfter = 0;
        errors = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = errorString.charAt(i);
            if (c == '1') {
                onesAfter++;
                errors += zeroesAfter * y;
            } else if (c == '0') {
                zeroesAfter++;
                errors += onesAfter * x;
            } else {
                int ones_Before = map.get(i)[1];
                int errorsWithZero = ones_Before * y + onesAfter * x;

                int zeroes_Before = map.get(i)[0];
                int errorsWithOne = zeroes_Before * x + zeroesAfter * y;

                if (errorsWithZero < errorsWithOne) {
                    errors += onesAfter * x;
                    zeroesAfter++;
                } else {
                    errors += zeroesAfter * y;
                    onesAfter++;
                }
            }
        }

        return errors % 1000000007;
    }

    public static void main(String[] args) {
        AmazonDatabaseError amazonDatabaseError = new AmazonDatabaseError();
        System.out.println(amazonDatabaseError.getMinErrors("01!0", 2, 2));
    }
}
