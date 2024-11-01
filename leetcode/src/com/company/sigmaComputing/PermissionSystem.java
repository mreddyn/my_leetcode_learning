package com.company.sigmaComputing;

import java.util.*;

public class PermissionSystem {

    // Map to store permissions: Item -> Set of Users
    private Map<Item, Set<User>> permissions;

    public PermissionSystem() {
        permissions = new HashMap<>();
    }

    // Grant permission to a user for an item
    public void grantPermission(Item item, User user) {
        permissions.computeIfAbsent(item, k -> new HashSet<>()).add(user);
    }

    // Check if a user has permission for an item (considering inheritance)
    public boolean hasPermission(Item item, User user) {
        Item currentItem = item;
        while (currentItem != null) {
            Set<User> usersWithPermission = permissions.get(currentItem);
            if (usersWithPermission != null && usersWithPermission.contains(user)) {
                return true;
            }
            currentItem = currentItem.getParent();
        }
        return false;
    }

    // User class
    public static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        // Override equals and hashCode for correct comparison in sets
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof User))
                return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public String getName() {
            return name;
        }
    }

    // Abstract Item class
    public static abstract class Item {
        protected String name;
        protected Folder parent;

        public Item(String name, Folder parent) {
            this.name = name;
            this.parent = parent;
        }

        public Folder getParent() {
            return parent;
        }

        public String getName() {
            return name;
        }
    }

    // Folder class
    public static class Folder extends Item {
        private List<Item> children;

        public Folder(String name, Folder parent) {
            super(name, parent);
            this.children = new ArrayList<>();
        }

        public void addItem(Item item) {
            children.add(item);
        }

        public List<Item> getChildren() {
            return children;
        }
    }

    // File class
    public static class File extends Item {
        public File(String name, Folder parent) {
            super(name, parent);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        PermissionSystem permissionSystem = new PermissionSystem();

        // Create users
        User alice = new User("Alice");
        User bob = new User("Bob");

        // Create folders and files
        Folder root = new Folder("root", null);
        Folder folderA = new Folder("FolderA", root);
        root.addItem(folderA);
        Folder folderB = new Folder("FolderB", root);
        root.addItem(folderB);
        File file1 = new File("File1", folderA);
        folderA.addItem(file1);
        File file2 = new File("File2", folderB);
        folderB.addItem(file2);

        // Grant permissions
        permissionSystem.grantPermission(root, alice);
        permissionSystem.grantPermission(folderB, bob);

        // Check permissions
        System.out.println("Does Alice have access to File1? " +
                permissionSystem.hasPermission(file1, alice)); // Should be true
        System.out.println("Does Bob have access to File1? " +
                permissionSystem.hasPermission(file1, bob)); // Should be false
        System.out.println("Does Bob have access to File2? " +
                permissionSystem.hasPermission(file2, bob)); // Should be true
        System.out.println("Does Alice have access to root? " +
                permissionSystem.hasPermission(root, alice)); // Should be true
        System.out.println("Does Bob have access to root? " +
                permissionSystem.hasPermission(root, bob)); // Should be false
    }
}
