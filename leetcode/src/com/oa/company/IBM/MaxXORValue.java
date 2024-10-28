package com.oa.company.IBM;

public class MaxXORValue {
    public int getMaxXor(int low, int high, int k) {
        int maxXor = 0;
        for (int i = low; i <= high; i++) {
            for (int j = i + 1; j <= high; j++) {
                int curXor = i ^ j;
                if (curXor <= k) {
                    maxXor = Math.max(maxXor, curXor);
                }
            }
        }
        return maxXor;
    }

    public static void main(String[] args) {
        MaxXORValue mValue = new MaxXORValue();
        System.out.println(mValue.getMaxXor(3, 5, 6));
        System.out.println(mValue.getMaxXor(1, 3, 3));
    }
}
