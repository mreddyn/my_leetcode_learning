package com.oa.company.goldmansachs;

public class FindLastKid {
    public int findLastKid(int N, int T, int D) {
        int lastKid = 0;
        int index = D;

        while (T > 0) {
            // give the candy to the kid at index
            lastKid = index;
            // decrease the number of candies
            T--;
            // go to the next kid
            index++;
            if (index > N) {
                index = 1;
            }
        }

        return lastKid;
    }

    private int findLastKidApproachTwo(int N, int T, int D) {
        return ((D - 1) + (T - 1)) % N + 1;
    }

    public static void main(String[] args) {
        FindLastKid obj = new FindLastKid();
        System.out.println(obj.findLastKid(5, 2, 1)); // 0
        System.out.println(obj.findLastKidApproachTwo(5, 2, 1));
    }

}
