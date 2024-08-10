package com.leetcode_daily_challenge;

public class CompareVersionNumbers {
    private int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;
        int n = Math.max(n1, n2);
        for (int i = 0; i < n; i++) {
            int i1 = (i < n1) ? Integer.parseInt(nums1[i]) : 0;
            int i2 = (i < n2) ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return (i1 > i2) ? 1 : -1;
            }
        }

        return 0;
    }

    private int compareVersionApproachTwo(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length(), temp1 = 0, temp2 = 0, i = 0, j = 0;
        while (i < n1 || j < n2) {
            temp1 = 0;
            temp2 = 0;
            while (i < n1 && version1.charAt(i) != '.') {
                temp1 = temp1 * 10 + version1.charAt(i++) - '0';
            }
            System.out.println(temp1);
            while (j < n2 && version2.charAt(j) != '.') {
                temp2 = temp2 * 10 + version2.charAt(j++) - '0';
            }
            System.out.println(temp2);
            if (temp1 > temp2) {
                return 1;
            } else if (temp1 < temp2) {
                return -1;
            } else {
                i++;
                j++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers cVersionNumbers = new CompareVersionNumbers();
        System.out.println(cVersionNumbers.compareVersion("1.01", "1.000001"));
        System.out.println(cVersionNumbers.compareVersionApproachTwo("1.01", "1.000001"));
    }
}
