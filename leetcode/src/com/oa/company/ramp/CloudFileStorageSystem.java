package com.oa.company.ramp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CloudFileStorageSystem {
    private HashMap<String, Integer> storage;
    private HashMap<String, User> users;

    CloudFileStorageSystem() {
        storage = new HashMap<>();
        users = new HashMap<>();
    }

    private class User {
        int capacity;
        int usedCapacity;
        HashSet<String> files;

        User(int capacity) {
            this.capacity = capacity;
            this.files = new HashSet<>();
            this.usedCapacity = 0;
        }

        boolean canAddFile(int size) {
            return (usedCapacity + size) <= capacity;
        }

        void addFile(String file, int size) {
            files.add(file);
            usedCapacity += size;
        }

        void removeFile(String file, int size) {
            files.remove(file);
            usedCapacity -= size;
        }

        int remainingCapacity() {
            return capacity - usedCapacity;
        }
    }

    private String add_user(String userId, int capacity) {
        if (users.containsKey(userId)) {
            return "false";
        }
        users.put(userId, new User(capacity));
        return "true";
    }

    private String ADD_FILE(String name, int size) {
        // admin file, admin has unlimited capacity
        if (storage.containsKey(name)) {
            return "false";
        }
        storage.put(name, size);
        if (!users.containsKey("admin")) {
            users.put("admin", new User(Integer.MAX_VALUE));
        }
        users.get("admin").files.add(name);
        users.get("admin").addFile(name, size);
        return "true";
    }

    private String ADD_FILE_BY(String userId, String name, int size) {
        return addFileByUser(userId, name, size);
    }

    private String addFileByUser(String userId, String name, int size) {
        if (storage.containsKey(name)) {
            return "";
        }
        User user = users.get(userId);
        if (user == null || !user.canAddFile(size)) {
            return "";
        }
        storage.put(name, size);
        user.addFile(name, size);
        return String.valueOf(user.remainingCapacity());
    }

    private String delete_File(String name) {
        if (!storage.containsKey(name)) {
            return "";
        }
        int size = storage.remove(name);
        for (User user : users.values()) {
            if (user.files.contains(name)) {
                user.removeFile(name, size);
                break;
            }
        }
        return String.valueOf(size);
    }

    private String mergeUser(String userId1, String userId2) {
        if (userId1.equals(userId2) || !users.containsKey(userId1) || !users.containsKey(userId2)) {
            return "";
        }
        User user1 = users.get(userId1);
        User user2 = users.get(userId2);
        for (String fileName : user2.files) {
            user1.addFile(fileName, storage.get(fileName));
        }
        user1.capacity += user2.capacity;
        users.remove(userId2);
        return String.valueOf(user1.remainingCapacity());
    }

    private String add_file(String file, int size) {
        if (storage.containsKey(file)) {
            return "false";
        }
        storage.put(file, size);
        return "true";
    }

    private String get_file_size(String file) {
        if (storage.containsKey(file)) {
            String size = storage.get(file).toString();
            return size;
        }
        return "";
    }

    private String delete_file(String file) {
        // if file exits then delete the file and return the size of that file
        // if file does not exist, then return empty string
        if (!storage.containsKey(file)) {
            return "";
        }
        String size = storage.get(file).toString();
        storage.remove(file);
        return size;
    }

    private String getNLargest(String prefix, int n) {
        List<Map.Entry<String, Integer>> filteredFiles = new ArrayList<>();
        // Get the files of matching prefix
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                filteredFiles.add(entry);
            }
        }

        // if no files match prefix then return empty string
        if (filteredFiles.size() == 0) {
            return "";
        }
        // sort the files by descending order by size and lexicographical if there is a
        // tie
        filteredFiles.sort((a, b) -> {
            int sizeComparison = b.getValue().compareTo(a.getValue());
            if (sizeComparison == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return sizeComparison;
        });

        StringBuilder result = new StringBuilder();
        int limit = Math.min(n, filteredFiles.size());
        for (int i = 0; i < limit; i++) {
            Map.Entry<String, Integer> entry = filteredFiles.get(i);
            result.append(entry.getKey()).append("(").append(entry.getValue()).append(")");
            if (i < limit - 1) {
                result.append(',');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CloudFileStorageSystem cStorageSystem = new CloudFileStorageSystem();
        // System.out.println(cStorageSystem.add_file("/dir/file1.txt", 5));
        // System.out.println(cStorageSystem.add_file("/dir/file2", 20));
        // System.out.println(cStorageSystem.add_file("/dir/deeper/file3.mov", 9));
        // System.out.println(cStorageSystem.getNLargest("/dir", 2));
        // System.out.println(cStorageSystem.getNLargest("/dir/file", 3));
        // System.out.println(cStorageSystem.getNLargest("/another_dir", 3));
        // System.out.println(cStorageSystem.add_file("/big_file.mp4", 20));
        // System.out.println(cStorageSystem.getNLargest("/", 2));

        System.out.println(cStorageSystem.add_user("user1", 200));
        System.out.println(cStorageSystem.add_user("user1", 100));
        System.out.println(cStorageSystem.ADD_FILE_BY("user1", "/dir/file.med", 50));
        System.out.println(cStorageSystem.ADD_FILE_BY("user1", "/file.big", 140));
        System.out.println(cStorageSystem.ADD_FILE_BY("user1", "/dir/file1.small", 20));
        System.out.println(cStorageSystem.ADD_FILE("/dir/admin_file", 300));
        System.out.println(cStorageSystem.add_user("user2", 110));
        System.out.println(cStorageSystem.ADD_FILE_BY("user2", "/dir/file.med", 50));
        System.out.println(cStorageSystem.ADD_FILE_BY("user2", "/new_file", 50));
        System.out.println(cStorageSystem.mergeUser("user1", "user2"));
    }
}
