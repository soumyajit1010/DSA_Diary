package DSA_Diary.daily.d_2025_10_16;

/*
💡 Problem: Search X in Sorted Array

📝 Problem Statement:
Given a sorted array of integers nums with 0-based indexing, find the index of a specified target integer.
If the target is found in the array, return its index.
If the target is not found, return -1.

🔹 Example 1:
Input: nums = [-1, 0, 3, 5, 9, 12], target = 9
Output: 4
Explanation: The target integer 9 exists in nums and its index is 4.

🔹 Example 2:
Input: nums = [-1, 0, 3, 5, 9, 12], target = 2
Output: -1
Explanation: The target integer 2 does not exist in nums, so return -1.

------------------------------------------------------------

✅ Approach 1: Iterative Binary Search
We repeatedly divide the search interval in half:
- Compare the target with the middle element.
- If equal → return mid.
- If target > mid element → search in the right half.
- Else → search in the left half.

------------------------------------------------------------

✅ Approach 2: Recursive Binary Search
We perform the same steps as the iterative approach but using recursion.

------------------------------------------------------------

⏱ Time Complexity (Both Approaches): O(log n)
👉 Each step halves the search space.

💾 Space Complexity:
- Iterative → O(1)
- Recursive → O(log n) (due to recursion stack)
*/

public class Search_X_in_sorted_array_TUF {

    // 🔹 Iterative Binary Search
    public int searchIterative(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // prevent overflow
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // 🔹 Recursive Binary Search
    public int searchRecursive(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;

        if (nums[mid] == target)
            return mid;
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        else
            return binarySearch(nums, low, mid - 1, target);
    }
}
