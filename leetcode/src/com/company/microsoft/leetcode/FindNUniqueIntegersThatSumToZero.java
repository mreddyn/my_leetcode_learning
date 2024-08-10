package com.company.microsoft.leetcode;

public class FindNUniqueIntegersThatSumToZero {
    public int[] sumZero(int n){
        int res[] = new int[n];
        int index, mid, min, max;
        mid = n/2;
        min = -1 * mid;
        max = mid;
        index = 0;
        for(int i=min;i<=max;i++){
            res[index++] = i;
        }
        return res;
    }
    public static void main(String[] args) {
        
    }
    
}
