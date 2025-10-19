/*
Problem: Search Insert Position

You are given a **sorted array** `nums` consisting of distinct integers and a **target value**.
Return the index if the target is found. If not, return the index where it would be if it were inserted in order.

Input:
- nums: sorted array of distinct integers
- target: integer to search or insert

Output:
- Index where target is found or should be inserted

Examples:

1. Input: nums = [1,3,5,6], target = 5
   Output: 2
   Explanation: 5 exists at index 2.

2. Input: nums = [1,3,5,6], target = 2
   Output: 1
   Explanation: 2 does not exist; it should be inserted at index 1.

Constraints:
- 1 <= nums.length <= 10^4
- nums contains distinct integers sorted in ascending order
- -10^4 <= nums[i], target <= 10^4
*/

package DSA_Diary.daily.d_2025_10_19;

public class Search_insert_position_TUF {

    // Function to find search insert position using binary search
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n; // default position if target > all elements

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                ans = mid;        // possible position found
                high = mid - 1;   // search left for smaller index
            } else {
                low = mid + 1;    // search right
            }
        }

        return ans;
    }
}

/*
Time Complexity (TC):
- Binary search halves the search space each iteration → O(log n)

Space Complexity (SC):
- Only a few variables used → O(1)
*/
