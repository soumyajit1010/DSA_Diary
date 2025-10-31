/*
153. Find Minimum in Rotated Sorted Array
------------------------------------------

🧩 Problem Statement:
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:
[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.

Given the sorted rotated array nums of unique elements,
return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

------------------------------------------
🧠 Examples:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and rotated 4 times.

Input: nums = [11,13,15,17]
Output: 11
Explanation: The array was rotated 4 times.
------------------------------------------

✅ Approach:
1. Use Binary Search to find the smallest element.
2. Check whether the left part is sorted or the right.
3. If the left part is sorted, update the answer and move right.
4. If the right part is unsorted, update the answer and move left.

------------------------------------------
⏱️ Time Complexity: O(log n)
📦 Space Complexity: O(1)
*/

package DSA_Diary.daily.d_2025_10_31;

public class Find_Minimum_in_Rotated_Sorted_Array_LeetCode {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If left part is sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            // If right part is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
