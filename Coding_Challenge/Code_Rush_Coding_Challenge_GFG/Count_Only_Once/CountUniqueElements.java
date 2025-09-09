package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Count_Only_Once;// Count Only Once
// Difficulty: Basic
// Accuracy: 86.49%
// You are given an integer array arr[] of integers. You need to find how many elements exist 
// if we count the elements only once. That is, repeated elements are counted as occurring once.

// Examples:
// Input: arr[] = [8, 8, 6, 5, 9, 9, 2]
// Output: 5
// Explanation: 8, 6, 5, 9, 2 — only 5 distinct elements

// Input: arr[] = [7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
// Output: 1
// Explanation: Only 1 unique element (7)

import java.util.*;

public class CountUniqueElements {
    public static int countOnlyOnce(int[] arr) {
        // Use a HashSet to store unique elements
        Set<Integer> unique = new HashSet<>();
        for (int num : arr) {
            unique.add(num); // duplicates are automatically ignored
        }
        return unique.size(); // number of unique elements
    }

    public static void main(String[] args) {
        int[] arr1 = {8, 8, 6, 5, 9, 9, 2};
        int[] arr2 = {7, 7, 7, 7, 7, 7, 7, 7};

        System.out.println(countOnlyOnce(arr1)); // Output: 5
        System.out.println(countOnlyOnce(arr2)); // Output: 1
    }
}
