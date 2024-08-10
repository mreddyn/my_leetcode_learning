package com.oa.company.paypal;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
        String a = "100";
        double c = 100.0;
        double d = 99.5632323;
        System.out.println(decimalFormat.format(Double.parseDouble(a)));
        System.out.println(decimalFormat.format(c));
        System.out.println(decimalFormat.format(d));
    }
}
