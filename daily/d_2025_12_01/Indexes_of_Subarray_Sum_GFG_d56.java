package DSA_Diary.daily.d_2025_12_01;

import java.util.ArrayList;

public class Indexes_of_Subarray_Sum_GFG_d56 {

    /*
     ======================================================================
       ❓ PROBLEM: Indexes of Subarray Sum (GFG)
       --------------------------------------------------------------------
       You are given an array `arr[]` containing NON-NEGATIVE integers.
       You need to find the FIRST continuous subarray that sums to `target`.

       👉 Return the LEFTMOST and RIGHTMOST 1-based indices.
       👉 If no such subarray exists, return [-1].

       --------------------------------------------------------------------
       🔹 Example 1:
            arr = [1, 2, 3, 7, 5], target = 12
            Output: [2, 4]

       🔹 Example 2:
            arr = [1, 2, 3, 4, 5, 6], target = 15
            Output: [1, 5]

       🔹 Example 3:
            arr = [5, 3, 4], target = 2
            Output: [-1]

       --------------------------------------------------------------------
       🔹 Constraints:
            • All elements are NON-NEGATIVE → Sliding Window works perfectly.
     ======================================================================
    */


    // ------------------------------------------------------------------
    // 1️⃣ OPTIMAL SOLUTION — SLIDING WINDOW
    //     Time Complexity:  O(n)
    //     Space Complexity: O(1)
    // ------------------------------------------------------------------
    static ArrayList<Integer> subarraySum(int[] arr, int target) {

        int start = 0;
        int currSum = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int end = 0; end < arr.length; end++) {

            currSum += arr[end];

            // Shrink window if sum becomes too large
            while (currSum > target && start < end) {
                currSum -= arr[start];
                start++;
            }

            // Check if we found the exact sum
            if (currSum == target) {
                res.add(start + 1); // convert to 1-based index
                res.add(end + 1);
                return res;
            }
        }

        res.add(-1);
        return res;
    }


    // ------------------------------------------------------------------
    // 2️⃣ BRUTE FORCE — CHECK EVERY SUBARRAY
    //     Time Complexity:  O(n²)
    //     Space Complexity: O(1)
    // ------------------------------------------------------------------
    static ArrayList<Integer> subarraySumBrute(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;

        for (int s = 0; s < n; s++) {
            int curr = 0;

            for (int e = s; e < n; e++) {
                curr += arr[e];

                if (curr == target) {
                    res.add(s + 1);  // convert to 1-based index
                    res.add(e + 1);
                    return res;
                }
            }
        }

        // If not found
        res.add(-1);
        return res;
    }

}
