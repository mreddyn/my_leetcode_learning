package com.company.microsoft.leetcode.medium;

import java.util.ArrayList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        /*
         * We will split the path by '/' (backslash) and iterate through them
         * If we encounter a empty directory or current directory (.) then we do nothing
         * if we encounter a .. (parent directory) then we remove last directory
         * anything else we add it to arrayList
         */
        String[] directories = path.split("/");
        ArrayList<String> dirs = new ArrayList<>();
        for (String directory : directories) {
            if (directory.isEmpty() || directory.equals(".")) {
                continue;
            } else if (directory.equals("..")) {
                if (dirs.isEmpty()) {
                    continue;
                } else {
                    dirs.remove(dirs.size() - 1);
                }
            } else {
                dirs.add(directory);
            }
        }

        String newPath = "/" + String.join("/", dirs);
        return newPath;
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
        System.out.println(simplifyPath.simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath.simplifyPath("/../"));
        System.out.println(simplifyPath.simplifyPath("/.../a/../b/c/../d/./"));
    }
}
