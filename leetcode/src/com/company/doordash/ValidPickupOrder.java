package com.company.doordash;

import java.util.HashSet;
import java.util.List;

public class ValidPickupOrder {
    public boolean validate(List<String> orders) {
        /*
         * Rules for Validity:
         * 
         * Pickup Uniqueness:
         * Each item can only be picked up once.
         * 
         * Delivery Order:
         * An item must be picked up before it can be delivered.
         * 
         * Completion Check:
         * At the end of the sequence, every item that was picked up should have been
         * delivered.
         */
        var pickedUp = new HashSet<Integer>();
        var droppedOff = new HashSet<Integer>();

        for (var order : orders) {
            if (order.charAt(0) == 'P') {
                int item = Integer.parseInt(order.substring(1));
                if (pickedUp.contains(item)) {
                    return false;
                }
                pickedUp.add(item);
            } else {
                int item = Integer.parseInt(order.substring(1));
                if (!pickedUp.contains(item)) {
                    return false;
                }
                if (droppedOff.contains(item)) {
                    return false;
                }
                droppedOff.add(item);
            }
        }

        return pickedUp.equals(droppedOff);
    }

    public static void main(String[] args) {
        ValidPickupOrder obj = new ValidPickupOrder();
        List<String> orders = List.of("P1", "P3", "P2", "D3", "P4", "P404", "D2", "D1", "D404", "D4",
                "P33", "D33");
        System.out.println(obj.validate(orders));
    }
}
