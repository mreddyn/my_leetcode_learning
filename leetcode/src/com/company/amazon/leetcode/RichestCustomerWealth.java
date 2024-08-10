package com.company.amazon.leetcode;

public class RichestCustomerWealth {
    private int maximumWealth(int[][] accounts) {
        int maxWealth = 0, currentWealth;
        for (int[] account : accounts) {
            currentWealth = 0;
            for (int money : account) {
                currentWealth += money;
            }
            maxWealth = Math.max(maxWealth, currentWealth);
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        RichestCustomerWealth richestCustomerWealth = new RichestCustomerWealth();
        System.out.println(richestCustomerWealth.maximumWealth(null));
    }
}
