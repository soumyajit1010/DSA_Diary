// Two sum - Pairs with 0 Sum
// Difficulty: Easy
// Given an integer array arr, return all the unique pairs [arr[i], arr[j]] such that i != j and arr[i] + arr[j] == 0.
// Note: The pairs must be returned in sorted order, the solution array should also be sorted,
// and the answer must not contain any duplicate pairs.
// Example:
// Input: arr = [-1, 0, 1, 2, -1, -4]
// Output: [[-1, 1]]
// Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
// Output: [[-6, 6], [-1, 1]]

package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Two_sum_Pairs_with_0_Sum;

import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<String> seenPairs = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int num : arr) {
            int complement = -num;
            if (set.contains(complement)) {
                int first = Math.min(num, complement);
                int second = Math.max(num, complement);
                String key = first + "," + second;
                if (!seenPairs.contains(key)) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(first);
                    pair.add(second);
                    result.add(pair);
                    seenPairs.add(key);
                }
            }
            set.add(num);
        }

        // Sort the result list of pairs
        result.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0)))
                return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });

        return result;
    }
}
