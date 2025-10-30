package DSA_Diary.daily.d_2025_10_30;

/*
🧩 Problem: Search in Rotated Sorted Array - II

There is an integer array nums sorted in non-decreasing order 
(not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) 
such that the resulting array is:
    [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).

For example: 
If nums = [0,1,2,4,4,4,5,6,6,7] and rotated at pivot index 5, 
then the array becomes [4,5,6,6,7,0,1,2,4,4].

Given the array nums after rotation and an integer target, 
return true if target exists in nums, otherwise return false.

You must decrease the overall operation steps as much as possible.

----------------------------------------------------------
🔹 Example 1:
Input:  nums = [2,5,6,0,0,1,2], target = 0
Output: true

🔹 Example 2:
Input:  nums = [2,5,6,0,0,1,2], target = 3
Output: false

----------------------------------------------------------
🔹 Approach:
Modified Binary Search (handles duplicates)

1️⃣ Use two pointers: low and high.
2️⃣ If nums[mid] == target → return true.
3️⃣ Handle duplicates by skipping boundaries if nums[low] == nums[mid] == nums[high].
4️⃣ Check which half is sorted (left or right).
5️⃣ Move search boundaries based on where the target lies.

----------------------------------------------------------
🔹 Time Complexity: O(log n) on average, 
   but can degrade to O(n) in the worst case (due to duplicates).
🔹 Space Complexity: O(1)
----------------------------------------------------------
*/

public class Search_in_rotated_sorted_array_II_LeetCode_81 {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Found target
            if (nums[mid] == target) return true;

            // Handle duplicates at boundaries
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1;  // Search right
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Search right
                } else {
                    high = mid - 1; // Search left
                }
            }
        }
        return false;
    }
}
