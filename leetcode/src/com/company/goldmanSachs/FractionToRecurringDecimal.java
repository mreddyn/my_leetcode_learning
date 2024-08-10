package com.company.goldmanSachs;

import java.util.HashMap;

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder fraction = new StringBuilder();
        // if numerator or denominator is negative then append negative sign
        if ((numerator < 0) ^ (denominator < 0)) {
            fraction.append('-');
        }
        // convert both numerator and denominator into long because of overflow when
        // divided by -1
        Long dividend = Math.abs(Long.valueOf(numerator));
        Long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) {
            // if remainder is zero then return the integral part
            return fraction.toString();
        }

        // fractional part
        fraction.append('.');
        HashMap<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                fraction.insert(index, '(');
                fraction.append(')');
                break;
            }
            map.put(remainder, fraction.length());
            remainder = remainder * 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder = remainder % divisor;
        }
        return fraction.toString();
    }
}
