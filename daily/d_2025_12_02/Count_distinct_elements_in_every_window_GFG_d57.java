package DSA_Diary.daily.d_2025_12_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Count_distinct_elements_in_every_window_GFG_d57 {

    /*
     =======================================================================================
     🔥 GFG: Count Distinct Elements in Every Window of Size K
     =======================================================================================

     You are given an array arr[] of length n and a window size k.
     For every contiguous window of size k, return the number of DISTINCT elements in it.

     ---------------------------------------------------------------------------------------
     Example 1:
     Input:
         arr = [1, 2, 1, 3, 4, 2, 3],  k = 4

     Windows & distinct count:
         [1, 2, 1, 3] → 3
         [2, 1, 3, 4] → 4
         [1, 3, 4, 2] → 4
         [3, 4, 2, 3] → 3

     Output:
         [3, 4, 4, 3]

     ---------------------------------------------------------------------------------------
     Example 2:
     Input:
         arr = [4, 1, 1],  k = 2

     Windows:
         [4, 1] → 2
         [1, 1] → 1

     Output:
         [2, 1]

     =======================================================================================
     🔵 Approach 1: Brute Force using HashSet
     =======================================================================================
     For each window:
         - Insert all k elements into a HashSet
         - Size of HashSet gives number of distinct elements

     Time Complexity:  O((n - k) * k)
     Space Complexity: O(k)

     =======================================================================================
     🔵 Approach 2: Optimal Sliding Window + HashMap
     =======================================================================================
     Use a frequency map to track counts of current window's elements.

     Steps:
       1. Build frequency map for first k elements → store map.size()
       2. Slide window from index k to n-1:
            • Add arr[i] to map
            • Remove arr[i-k] from map (decrease frequency, remove if 0)
            • Add map.size() to result

     Time Complexity:  O(n)
     Space Complexity: O(k)

     This is the expected optimal solution.
     =======================================================================================
     */


    // -------------------------------------------------------------------
    // 🔵 Brute Force Approach
    // -------------------------------------------------------------------
    ArrayList<Integer> countDistinct(int arr[], int k) {

        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i <= n - k; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(arr[j]);
            }

            result.add(set.size());
        }

        return result;
    }


    // -------------------------------------------------------------------
    // 🔵 Optimal Sliding Window Approach
    // -------------------------------------------------------------------
    class Solution {
        ArrayList<Integer> countDistinct(int arr[], int k) {

            ArrayList<Integer> result = new ArrayList<>();
            int n = arr.length;

            HashMap<Integer, Integer> freq = new HashMap<>();

            // Build map for first window
            for (int i = 0; i < k; i++) {
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            }

            result.add(freq.size());

            // Slide the window
            for (int i = k; i < n; i++) {

                // Add new element
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

                // Remove element leaving the window
                freq.put(arr[i - k], freq.get(arr[i - k]) - 1);

                // If its frequency becomes zero → remove
                if (freq.get(arr[i - k]) == 0) {
                    freq.remove(arr[i - k]);
                }

                // Distinct count for current window
                result.add(freq.size());
            }

            return result;
        }
    }
}
