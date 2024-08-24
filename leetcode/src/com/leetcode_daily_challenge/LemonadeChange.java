package com.leetcode_daily_challenge;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length, fiveDollarBills = 0, tenDollarBills = 0;
        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {
                // if customer gives 5$ bill, then just give them lemonade and move on (we have
                // one 5$ bill in hand)
                fiveDollarBills++;
            } else if (bills[i] == 10) {
                // if customer provides 10$ bill, then give them one 5$ bill.
                // if no five dollar bill then return false; and increase 10$ bill count
                if (fiveDollarBills >= 1) {
                    fiveDollarBills--;
                    tenDollarBills++;
                } else {
                    return false;
                }
            } else {
                // if customer gives 20$ bill, then we need to give back one 10$ bill and 2 5$
                // bills or three 5$ bills.
                // if any of two cases is not possible then return false;
                if (tenDollarBills >= 1 && fiveDollarBills >= 1) {
                    tenDollarBills--;
                    fiveDollarBills--;
                } else if (fiveDollarBills >= 3) {
                    fiveDollarBills -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
