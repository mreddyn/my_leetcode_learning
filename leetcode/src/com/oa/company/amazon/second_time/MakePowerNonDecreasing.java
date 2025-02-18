package com.oa.company.amazon.second_time;

public class MakePowerNonDecreasing {
    public int makePowerNonDescreasing(int[] powa) {
        int res = 0, prev = powa[0];
        for (int num : powa) {
            res += Math.max(0, prev - num);
            prev = num;
        }
        return res;
    }

    public static void main(String[] args) {
        MakePowerNonDecreasing obj = new MakePowerNonDecreasing();
        System.out.println(obj.makePowerNonDescreasing(new int[] { 3, 4, 1, 6, 2 }));
        System.out.println(obj.makePowerNonDescreasing(new int[] { 3, 2, 1 }));
        System.out.println(obj.makePowerNonDescreasing(new int[] { 3, 3, 2, 3 }));
    }

}
