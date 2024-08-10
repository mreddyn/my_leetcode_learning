package com.oa.company.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartBilling {
    private static int minCost(List<List<String>> products, List<List<String>> discounts) {
         // Create a map for quick lookup of discounts by their tags
        Map<String, List<int[]>> discountMap = new HashMap<>();
        for (List<String> discount : discounts) {
            String tag = discount.get(0);
            int type = Integer.parseInt(discount.get(1));
            int amount = Integer.parseInt(discount.get(2));

            // Map each tag to a list of discounts in case of multiple discount types per tag
            if (!discountMap.containsKey(tag)) {
                discountMap.put(tag, new ArrayList<>());
            }
            discountMap.get(tag).add(new int[]{type, amount});
        }

        int totalCost = 0;
        for (List<String> product : products) {
            int price = Integer.parseInt(product.get(0));
            int minPrice = price;  // Start with the original price

            for (int i = 1; i < product.size(); i++) {
                String discountTag = product.get(i);
                if (!discountTag.equals("EMPTY") && discountMap.containsKey(discountTag)) {
                    // Check all applicable discounts
                    for (int[] discount : discountMap.get(discountTag)) {
                        int discountedPrice = calculateDiscountedPrice(price, discount);
                        minPrice = Math.min(minPrice, discountedPrice);
                    }
                }
            }

            totalCost += minPrice;  // Sum up the minimum prices
        }

        return totalCost;

    }

    private static int calculateDiscountedPrice(int price, int[] discount) {
        int type = discount[0];
        int amount = discount[1];
        switch (type) {
            case 0: // Fixed price
                return amount;
            case 1: // Percentage discount
                return (int) Math.floor(price - price * amount / 100.0); // Use floating point division for percentage
            case 2: // Fixed discount
                return price - amount;
            default:
                return price;
        }
    }

    public static void main(String[] args) {
        List<List<String>> products = Arrays.asList(
                Arrays.asList("100", "dcoupon1"),
                Arrays.asList("50", "dcoupon1"),
                Arrays.asList("30", "dcoupon1"),
                Arrays.asList("100", "dcoupon2"),
                Arrays.asList("50", "dcoupon2"),
                Arrays.asList("30", "dcoupon2")
        );
        List<List<String>> discounts = Arrays.asList(
                Arrays.asList("dcoupon1", "0", "60"),
                Arrays.asList("dcoupon1", "1", "30"),
                Arrays.asList("dcoupon1", "1", "20"),
                Arrays.asList("dcoupon2", "2", "20"),
                Arrays.asList("dcoupon2", "1", "85"),
                Arrays.asList("dcoupon2", "0", "15")
        );



        System.out.println(minCost(products, discounts));
    }
}
