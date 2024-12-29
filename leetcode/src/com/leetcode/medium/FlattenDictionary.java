package com.leetcode.medium;

import java.util.HashMap;

public class FlattenDictionary {
    public HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        var flatDictionary = new HashMap<String, String>();
        flatten("", dict, flatDictionary);
        return flatDictionary;
    }

    private void flatten(String initialKey, HashMap<String, Object> dict, HashMap<String, String> flatDictionary) {
        // Iterate over the HashMap
        for (var entry : dict.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            var newKey = initialKey.isEmpty() ? key : initialKey + (key.isEmpty() ? "" : "." + key);

            if (value instanceof HashMap) {
                flatten(newKey, (HashMap<String, Object>) value, flatDictionary);
            } else {
                flatDictionary.put(newKey, (String) value);
            }
        }
    }

    public static void main(String[] args) {
        FlattenDictionary fDictionary = new FlattenDictionary();
        // debug your code below
        HashMap<String, Object> dictInput = new HashMap<>();
        dictInput.put("Key1", "1");
        HashMap<String, Object> nestedMap = new HashMap<>();
        nestedMap.put("a", "2");
        nestedMap.put("b", "3");
        HashMap<String, Object> nestedNestedMap = new HashMap<>();
        nestedNestedMap.put("d", "3");
        HashMap<String, Object> nestedNestedNestedMap = new HashMap<>();
        nestedNestedNestedMap.put("", "1");
        nestedNestedMap.put("e", nestedNestedNestedMap);
        nestedMap.put("c", nestedNestedMap);
        dictInput.put("Key2", nestedMap);

        HashMap<String, String> output = fDictionary.flattenDictionary(dictInput);
        System.out.println(output);
    }
}
