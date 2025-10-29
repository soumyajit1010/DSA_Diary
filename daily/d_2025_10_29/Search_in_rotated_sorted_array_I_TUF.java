package DSA_Diary.daily.d_2025_10_29;

/*
🧩 Problem: Search in Rotated Sorted Array - I

Given an integer array nums sorted in ascending order (with distinct values)
and a target value k. The array is rotated at some pivot point that is unknown.
Find the index at which k is present. If k is not present, return -1.

🔹 Example 1:
Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 0
Output: 4
Explanation: 0 is found at index 4.

🔹 Example 2:
Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3
Output: -1
Explanation: 3 is not present in the array.

-------------------------------------------------
🔹 Approach:
Use a modified Binary Search:
1️⃣ Find the middle element.
2️⃣ Determine which side (left or right) is sorted.
3️⃣ Check if the target lies in the sorted part:
    - If yes, move within that part.
    - Else, search in the unsorted part.

-------------------------------------------------
🔹 Time Complexity: O(log n)
🔹 Space Complexity: O(1)
-------------------------------------------------
*/

public class Search_in_rotated_sorted_array_I_TUF {
    public int search(int[] arr, int t) {

        int l = 0, h = arr.length - 1; // ✅ fix: high should be length-1

        while (l <= h) {
            int m = (l + h) / 2;

            if (arr[m] == t) return m; // target found

            // Left half is sorted
            if (arr[l] <= arr[m]) {
                if (arr[l] <= t && t < arr[m]) {
                    h = m - 1; // search left side
                } else {
                    l = m + 1; // search right side
                }
            }
            // Right half is sorted
            else {
                if (arr[m] < t && t <= arr[h]) {
                    l = m + 1; // search right side
                } else {
                    h = m - 1; // search left side
                }
            }
        }
        return -1; // target not found
    }
}
