package com.leetcode_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class NumberOfLaserBeamsInABank {
    private int numberOfBeams(String[] bank) {
        List<Integer> securityDevicesByRow = new ArrayList<>();
        for (int row = 0; row < bank.length; row++) {
            int securityDevicesInRow = 0;
            for (int col = 0; col < bank[row].length(); col++) {
                if (bank[row].charAt(col) == '1') {
                    securityDevicesInRow++;
                }
            }
            if (securityDevicesInRow > 0) {
                securityDevicesByRow.add(securityDevicesInRow);
            }
        }
        int laserBeams = 0;
        for (int index = 1; index < securityDevicesByRow.size(); index++) {
            laserBeams += securityDevicesByRow.get(index - 1) * securityDevicesByRow.get(index);
        }
        return laserBeams;
    }

    public static void main(String[] args) {
        NumberOfLaserBeamsInABank n = new NumberOfLaserBeamsInABank();
        String[] bank = { "011001", "000000", "010100", "001000" };
        System.out.println(n.numberOfBeams(bank));
    }
}
