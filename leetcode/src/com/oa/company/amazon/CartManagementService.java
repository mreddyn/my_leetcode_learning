package com.oa.company.amazon;

import java.util.ArrayList;
import java.util.List;

public class CartManagementService {
    public List<Integer> processQueriesOnCart(int[] items, int[] queries) {
        // convert items from array to List for easy addition and deletion
        List<Integer> cart = new ArrayList<>();
        for (int item : items) {
            cart.add(item);
        }

        for (int query : queries) {
            if (query < 0) {
                cart.remove(Integer.valueOf(-query));
            } else {
                cart.add(query);
            }
        }

        return cart;
    }

    public static void main(String[] args) {
        CartManagementService cService = new CartManagementService();
        System.out.println(cService.processQueriesOnCart(new int[] { 1, 2, 1, 2, 1 }, new int[] { -1, -1, 3, 4, -1 }));
    }
}
