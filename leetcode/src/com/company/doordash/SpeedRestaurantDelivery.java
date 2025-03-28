package com.company.doordash;

public class SpeedRestaurantDelivery {
    private int minDeliverySpeed(int[] orders, int time) {
        int left = 1;
        int right = 0;

        for (int order : orders) {
            right = Math.max(right, order);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(orders, time, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(int[] orders, int time, int speed) {
        int count = 0;
        for (int order : orders) {
            count += (order / speed);
            if (order % speed != 0) {
                count++;
            }

            if (count > time) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SpeedRestaurantDelivery speedRestaurantDelivery = new SpeedRestaurantDelivery();
        int[] orders = { 2, 8, 4, 10, 6 };
        System.out.println(speedRestaurantDelivery.minDeliverySpeed(orders, 5)); // 1
    }
}
