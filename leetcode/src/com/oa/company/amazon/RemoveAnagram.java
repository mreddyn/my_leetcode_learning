package com.oa.company.amazon;

import java.util.*;

public class RemoveAnagram {

    public static String[] removeAnagram(String[] textList) {
        // A set to store unique sorted versions of the strings
        Set<String> seen = new HashSet<>();
        // A list to store the result strings
        List<String> result = new ArrayList<>();

        // Iterate over the strings in the input list
        for (String text : textList) {
            // Convert the string to a char array, sort it, and convert it back to a string
            char[] chars = text.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            // If the sorted string is not in the set, add the original string to the result
            if (!seen.contains(sorted)) {
                seen.add(sorted);
                result.add(text);
            }
        }

        // Sort the result list in ascending order
        Collections.sort(result);

        // Convert the result list to an array and return
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Test case
        String[] textList = { "code", "doce", "ecod", "framer", "frame" };
        String[] result = removeAnagram(textList);

        // Output the result
        System.out.println(Arrays.toString(result));
    }
}
