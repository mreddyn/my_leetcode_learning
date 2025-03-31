package com.company.doordash;

import java.util.HashMap;

public class FileSystemAPI {
    private Node root;

    FileSystemAPI() {
        root = new Node("");
    }

    public void createPath(String path, String value) {
        if (path == null || path.isEmpty() || !path.startsWith("/") || path.equals("/")) {
            throw new IllegalArgumentException("Invalid path");
        }

        // split the path into parts
        // /a/b/c => a, b, c
        var parts = path.split("/");
        var node = root;
        // traverse to the parent node of the node to be created
        for (int i = 1; i < parts.length - 1; i++) {
            if (!node.children.containsKey(parts[i])) {
                throw new IllegalArgumentException();
            }
            node = node.children.get(parts[i]);
        }

        var lastPart = parts[parts.length - 1];
        if (lastPart.isEmpty()) {
            throw new IllegalArgumentException("Invalid path");
        }

        if (node.children.containsKey(lastPart)) {
            throw new IllegalArgumentException("Path already exists");
        }

        Node newNode = new Node(value);
        node.children.put(lastPart, newNode);
    }

    public String get(String path) {
        var node = traverse(path);
        if (node == null) {
            throw new IllegalArgumentException("path does not exist");
        }
        return node.value;
    }

    public void delete(String path) {
        if (path == null || path.isEmpty() || !path.startsWith("/") || path.equals("/")) {
            throw new IllegalArgumentException();
        }

        var parts = path.split("/");
        Node curr = root;
        Node parent = null;
        String childKey = "";

        for (int i = 1; i < parts.length; i++) {
            if (!curr.children.containsKey(parts[i])) {
                throw new IllegalArgumentException();
            }
            parent = curr;
            curr = curr.children.get(parts[i]);
            childKey = parts[i];
        }

        // only allow deletion if it is a leaf
        if (!curr.children.isEmpty()) {
            throw new IllegalArgumentException("Cannot delete node since it has children");
        }

        parent.children.remove(childKey);
    }

    public void set(String path, String value) {
        var node = traverse(path);
        if (node == null) {
            throw new IllegalArgumentException("path does not exist");
        }
        node.value = value;
    }

    private Node traverse(String path) {
        if (path == null || path.isEmpty() || !path.startsWith("/")) {
            return null;
        }

        // root node represents /
        if (path.equals("/")) {
            return root;
        }

        var parts = path.split("/");
        var curr = root;
        for (int i = 1; i < parts.length; i++) {
            if (!curr.children.containsKey(parts[i])) {
                return null;
            }
            curr = curr.children.get(parts[i]);
        }
        return curr;

    }

    class Node {
        String value;
        HashMap<String, Node> children;

        Node(String value) {
            this.value = value;
            this.children = new HashMap<>();
        }
    }
}
