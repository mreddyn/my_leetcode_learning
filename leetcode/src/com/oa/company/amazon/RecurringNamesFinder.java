package com.oa.company.amazon;

import java.util.*;

public class RecurringNamesFinder {

    public static String[] findRecurringNames(String[] realNames, String[] allNames) {
        // Map to store the canonical form of each real name
        Map<String, String> realNameToCanonical = new HashMap<>();
        for (String name : realNames) {
            String canonical = getCanonicalForm(name);
            realNameToCanonical.put(canonical, name);
        }

        // Map to count occurrences of each canonical form in allNames
        Map<String, Integer> canonicalCount = new HashMap<>();
        for (String name : allNames) {
            String canonical = getCanonicalForm(name);
            canonicalCount.put(canonical, canonicalCount.getOrDefault(canonical, 0) + 1);
        }

        // List to store the names that have multiple accounts
        List<String> recurringNames = new ArrayList<>();
        for (Map.Entry<String, String> entry : realNameToCanonical.entrySet()) {
            String canonical = entry.getKey();
            String realName = entry.getValue();
            if (canonicalCount.getOrDefault(canonical, 0) > 1) {
                recurringNames.add(realName);
            }
        }

        // Sort the names lexicographically and return
        Collections.sort(recurringNames);
        if (recurringNames.isEmpty()) {
            return new String[] { "None" };
        } else {
            return recurringNames.toArray(new String[0]);
        }
    }

    // Helper function to get the canonical form (sorted string)
    private static String getCanonicalForm(String name) {
        char[] charArray = name.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        String[] realNames1 = { "rohn", "henry", "daisy" };
        String[] allNames1 = { "ryhen", "aisyd", "henry" };
        System.out.println(Arrays.toString(findRecurringNames(realNames1, allNames1))); // Output: ["henry"]

        String[] realNames2 = { "tom", "jerry" };
        String[] allNames2 = { "reyjr", "mot", "tom", "jerry", "mto" };
        System.out.println(Arrays.toString(findRecurringNames(realNames2, allNames2))); // Output: ["jerry", "tom"]
    }
}
