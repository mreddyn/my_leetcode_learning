package com.company.amazon.leetcode;

public class ConvertTheTemperature {
    private double[] convertTemperature(double celsius) {
        double[] ans = new double[2];
        ans[0] = celsius + 273.15;
        ans[1] = celsius * 1.80 + 32.00;
        return ans;
    }

    public static void main(String[] args) {
        ConvertTheTemperature convertTheTemperature = new ConvertTheTemperature();
        double[] ans = convertTheTemperature.convertTemperature(36.50);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
