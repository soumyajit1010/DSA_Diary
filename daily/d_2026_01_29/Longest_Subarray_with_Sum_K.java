package DSA_Diary.daily.d_2026_01_29;/*
Longest Subarray with Sum K

Problem Statement:
Given an array arr[] of integers and an integer k, find the length of the
longest subarray whose sum is equal to k.
If no such subarray exists, return 0.

Examples:
Input: arr = [10, 5, 2, 7, 1, -10], k = 15
Output: 6

Input: arr = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5

Input: arr = [10, -10, 20, 30], k = 5
Output: 0
*/

import java.util.*;

class Longest_Subarray_with_Sum_K {

    /*
     Brute Force Approach
     --------------------
     Time Complexity: O(n^2)
     Space Complexity: O(1)
     */
    public int longestSubarrayBruteForce(int[] arr, int k) {

        int n = arr.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    /*
     Optimized Approach (Prefix Sum + HashMap)
     -----------------------------------------
     Time Complexity: O(n)
     Space Complexity: O(n)
     */
    public int longestSubarrayOptimized(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If subarray starts from index 0
            if (prefixSum == k) {
                maxLen = i + 1;
            }

            // If subarray exists in between
            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }

            // Store first occurrence of prefix sum
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
}
