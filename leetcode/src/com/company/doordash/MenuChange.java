package com.company.doordash;

import java.util.HashMap;
import java.util.List;

public class MenuChange {
    public int getModifiedItemsCount(Node oldMenu, Node newMenu) {
        var existingMenuMap = new HashMap<String, Node>();
        var newMenuMap = new HashMap<String, Node>();

        // Traverse the old menu and store the items in a map
        traverseMenu(oldMenu, existingMenuMap);

        // Traverse the new menu and store the items in a map
        traverseMenu(newMenu, newMenuMap);

        // Compare the two maps
        return compare(existingMenuMap, newMenuMap);
    }

    private int compare(HashMap<String, Node> existingMenuMap, HashMap<String, Node> newMenuMap) {
        int count = 0;
        // Compare nodes in the existing menu.
        for (var entry : existingMenuMap.entrySet()) {
            String key = entry.getKey();
            // If the key is not present in the new menu, it means it was removed.
            if (!newMenuMap.containsKey(key)) {
                count++;
                continue;
            }
            // If the key is present in both menus, compare the values.
            // If the values are different, it means the node was modified.
            // If the node is not active in the new menu, it means it was removed.
            // If the node is not active in the existing menu, it means it was added.
            // If the node is active in both menus, it means it was not modified.
            // If the node is active in the existing menu and not active in the new menu,
            // it means it was removed.
            Node existingNode = entry.getValue();
            Node newNode = newMenuMap.get(key);

            if (newNode == null ||
                    (existingNode.active != newNode.active || existingNode.value != newNode.value)) {
                // Node was removed in the new menu.
                count++;
            }
        }

        // Now, count nodes that are newly added in the new menu.
        for (String key : newMenuMap.keySet()) {
            if (!existingMenuMap.containsKey(key)) {
                count++;
            }
        }

        return count;
    }

    private void traverseMenu(Node node, HashMap<String, Node> menuMap) {
        if (node == null) {
            return;
        }

        // Store the node in the map
        menuMap.put(node.key, node);

        // Traverse the children
        for (Node child : node.children) {
            traverseMenu(child, menuMap);
        }
    }

    class Node {
        String key;
        int value;
        boolean active;
        List<Node> children;
    }
}
