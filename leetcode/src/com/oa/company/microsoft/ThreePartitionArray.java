package com.oa.company.microsoft;

public class ThreePartitionArray {
    public int[] threePartitionArray(int[] arr, int lowVal, int highVal) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        for (int i = 0; i <= high;) {
            if (arr[i] < lowVal) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] > highVal) {
                swap(arr, i, high);
                high--;
            } else {
                i++;
            }
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ThreePartitionArray obj = new ThreePartitionArray();

        // Example 1
        int[] A1 = { 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32 };
        int[] res1 = obj.threePartitionArray(A1, 14, 20);
        for (int num : res1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 2
        int[] A2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] res2 = obj.threePartitionArray(A2, 1, 9);
        for (int num : res2) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 3
        int[] A3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] res3 = obj.threePartitionArray(A3, 9, 1);
        for (int num : res3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
