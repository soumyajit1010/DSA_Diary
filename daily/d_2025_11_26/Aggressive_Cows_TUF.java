package DSA_Diary.daily.d_2025_11_26;

import java.util.Arrays;

/*
---------------------------------------------
   🐄 Aggressive Cows – Problem Statement
---------------------------------------------
You are given an array nums[] of size n, representing stall positions,
and an integer k representing the number of cows.

Place the k cows in these stalls such that the **minimum distance**
between any two cows is **maximized**.

Return the **maximum possible minimum distance**.

---------------------------------------------
Example 1:
Input: n = 6, k = 4, nums = [0, 3, 4, 7, 10, 9]
Output: 3

Example 2:
Input: n = 5, k = 2, nums = [4, 2, 1, 3, 6]
Output: 5
---------------------------------------------

---------------------------------------------
❌ Approach 1: Brute Force (Try all distances)
---------------------------------------------
• Try all distances from 1 to max-min
• For each distance, check if cows can be placed

Time Complexity:
• Sorting: O(n log n)
• Trying distances up to (max-min): O(max-min)
• Checking placement: O(n)

Total Time: ❌ O((max − min) * n)  → Too Slow for large values
---------------------------------------------

---------------------------------------------
✅ Approach 2: Binary Search on Answer (Optimal)
---------------------------------------------
• Search distance range [1 ... max-min]
• Check using greedy if mid distance is possible

Time Complexity:
• Sorting: O(n log n)
• Binary search on distance: O(log(max-min))
• Each placement check: O(n)

Total Time: ✅ O(n log(max-min)) → Efficient
---------------------------------------------
*/

public class Aggressive_Cows_TUF {

    // ---------------- BRUTE FORCE ----------------
    // Time Complexity: O((max-min) * n)
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[nums.length - 1];

        int ans = 0;

        for (int dist = 1; dist <= max - min; dist++) {
            if (canWePlace(nums, dist, k)) {
                ans = dist;
            } else {
                break;
            }
        }
        return ans;
    }

    // Greedy checking function
    public boolean canWePlace(int[] nums, int dist, int k) {
        int countCows = 1;
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last >= dist) {
                countCows++;
                last = nums[i];
            }
        }
        return countCows >= k;
    }


    // ---------------- OPTIMAL BINARY SEARCH SOLUTION ----------------
    // Time Complexity: O(n log(max-min))
    public int aggressiveCows2(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canWePlace(stalls, mid, k)) {
                ans = mid;
                low = mid + 1;   // Try larger distance
            } else {
                high = mid - 1;  // Try smaller distance
            }
        }
        return ans;
    }
}
