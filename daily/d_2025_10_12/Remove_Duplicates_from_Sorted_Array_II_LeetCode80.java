package DSA_Diary.daily.d_2025_10_12;
/*
📘 80. Remove Duplicates from Sorted Array II
---------------------------------------------------
Given an integer array nums sorted in non-decreasing order,
remove some duplicates in-place such that each unique element appears at most twice.
The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages,
you must instead have the result be placed in the first part of the array nums.
More formally, if there are k elements after removing the duplicates,
then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array.
You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]

Example 2:
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
---------------------------------------------------

✅ Approach:
We use the two-pointer technique.
- Pointer `i` tracks the position of the next valid element to be written.
- Pointer `j` iterates over each element in the array.
- We only keep an element if it appears less than or equal to twice.

Steps:
1. If the current element `nums[j]` is not equal to `nums[i-2]`,
   then it means it can safely be added.
2. We assign `nums[i] = nums[j]` and increment `i`.

At the end, `i` gives the count of elements allowed (k).

---------------------------------------------------
⏱️ Time Complexity: O(n)
🧠 Space Complexity: O(1)
---------------------------------------------------
*/
import java.util.HashMap;

public class Remove_Duplicates_from_Sorted_Array_II_LeetCode80 {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n <= 2) return n;  // If array has 2 or fewer elements, no need to modify

        int i = 2; // Pointer for the position to place the next valid number

        for (int j = 2; j < n; j++) {
            // Only add nums[j] if it's not equal to the element two steps behind
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i; // i is the new length
    }
}
