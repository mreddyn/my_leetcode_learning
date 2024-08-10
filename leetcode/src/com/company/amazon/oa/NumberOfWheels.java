package com.company.amazon.oa;

public class NumberOfWheels {
    private static int[] chooseFleets(int []wheels){
        int n;
        n = wheels.length;
        
        return wheels;
    }
    private static int helper(int amount, int []coins){
        int [][]dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(chooseFleets(new int []{4,5,6}));
    }
    
}
