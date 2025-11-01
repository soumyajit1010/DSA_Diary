/*
💡 Problem: Find out how many times the array is rotated
---------------------------------------------------------
Given an integer array nums of size n, sorted in ascending order
with distinct values. The array has been right rotated an unknown
number of times, between 0 and n-1 (including).

Determine the number of rotations performed on the array.

---------------------------------------------------------
🧩 Examples:

Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
Output: 4
Explanation: The original array [0,1,2,3,4,5,6,7]
has been rotated 4 times.

Input : nums = [3, 4, 5, 1, 2]
Output: 3
Explanation: The original array [1,2,3,4,5]
has been rotated 3 times.

Input : nums = [4, 5, 1, 2]
Output: 2

---------------------------------------------------------
✅ Approach:
- The number of rotations equals the index of the smallest element.
- Use Binary Search to find the minimum element efficiently.
- The minimum element is the only element smaller than both its neighbors
  (or the left part is greater than the right part).

---------------------------------------------------------
⏱️ Time Complexity: O(log n)
📦 Space Complexity: O(1)
*/

package DSA_Diary.daily.d_2025_11_01;

import java.util.ArrayList;

public class Find_out_how_many_times_the_array_is_rotated_TUF {
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0, high = nums.size() - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If the subarray is already sorted
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
                break;
            }

            // Left half is sorted
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
                low = mid + 1;
            }
            // Right half is sorted
            else {
                if (nums.get(mid) < ans) {
                    ans = nums.get(mid);
                    index = mid;
                }
                high = mid - 1;
            }
        }
        return index; // index represents number of rotations
    }
}
