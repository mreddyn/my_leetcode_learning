package com.oa.company.tiktok;

public class LongestConcaveSubsequence {

    public static int maxLength(int[] arr) {
        int n = arr.length;

        if (n == 1)
            return 1; // If only one element, the subsequence length is 1

        int[] dp_left = new int[n];
        int[] dp_right = new int[n];

        // Initialize dp_left and dp_right arrays with 1 (minimum length subsequence)
        for (int i = 0; i < n; i++) {
            dp_left[i] = 1;
            dp_right[i] = 1;
        }

        // Compute dp_left: Longest increasing subsequence ending at each index
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp_left[i] = Math.max(dp_left[i], dp_left[j] + 1);
                }
            }
        }

        // Compute dp_right: Longest decreasing subsequence starting at each index
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp_right[i] = Math.max(dp_right[i], dp_right[j] + 1);
                }
            }
        }

        // Find the maximum length of a concave subsequence
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp_left[i] + dp_right[i] - 1);
        }

        return maxLength;
    }

    /*
     * int findLen(vector<int> vec){
    int ans = 0;
    for(int i=0;i<vec.size(); i++){
        for(int j=i+1;j<vec.size();j++){
            int a = vec[i];	
            int b = vec[j];
            bool bln = true;
            int count = 2;
            for(int k=i+1;k<j;k++){
                if(vec[k]<a && vec[k]<b){
                Count++;
                }
            }
            if(bln){
            ans = max(ans, count);
            }
        }
    }
    return ans;
} passed 9/15 Test cases
     */

    public static void main(String[] args) {
        int[] arr1 = { 4, 2, 6, 5, 3, 1 };
        int[] arr2 = { 3, 1, 5, 2, 4 };
        int[] arr3 = { 1, 2, 3, 4, 5 };

        System.out.println(maxLength(arr1)); // Output: 3
        System.out.println(maxLength(arr2)); // Output: 4
        System.out.println(maxLength(arr3)); // Output: 2
    }
}
