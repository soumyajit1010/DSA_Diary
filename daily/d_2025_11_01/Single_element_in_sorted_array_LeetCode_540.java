/*
💡 Problem: 540. Single Element in a Sorted Array
---------------------------------------------------------
You are given a sorted array where every element appears exactly twice
except one element which appears only once.

Return that single element.

---------------------------------------------------------
🧩 Examples:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Input: nums = [3,3,7,7,10,11,11]
Output: 10

---------------------------------------------------------
✅ Approach:
- Use Binary Search.
- For each mid:
   - If mid is even and nums[mid] == nums[mid+1], single element is on right.
   - If mid is odd and nums[mid] == nums[mid-1], single element is on right.
   - Otherwise, it's on the left.
- Continue until l == h.

---------------------------------------------------------
⏱️ Time Complexity: O(log n)
📦 Space Complexity: O(1)
*/

package DSA_Diary.daily.d_2025_11_01;

public class Single_element_in_sorted_array_LeetCode_540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int m = (l + h) / 2;

            // Ensure mid is even (so we always compare with next element)
            if (m % 2 == 1) m--;

            if (nums[m] == nums[m + 1]) {
                // Single element lies on right half
                l = m + 2;
            } else {
                // Single element lies on left half (including mid)
                h = m;
            }
        }

        return nums[l]; // When loop ends, l == h, which is the single element
    }
}
