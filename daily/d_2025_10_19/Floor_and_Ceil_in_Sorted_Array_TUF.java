/*
Problem: Floor and Ceil in Sorted Array

Given a **sorted array** `nums` and an integer `x`, find the **floor** and **ceil** of `x` in the array.

📘 Definitions:
- **Floor(x)** = largest element in the array ≤ x
- **Ceil(x)** = smallest element in the array ≥ x
- If no floor or ceil exists, output **-1**

---

🔹 Example 1:
Input: nums = [3, 4, 4, 7, 8, 10], x = 5
Output: 4 7
Explanation:
- Floor of 5 → 4 (largest number ≤ 5)
- Ceil of 5 → 7 (smallest number ≥ 5)

🔹 Example 2:
Input: nums = [3, 4, 4, 7, 8, 10], x = 8
Output: 8 8
Explanation:
- Floor of 8 → 8
- Ceil of 8 → 8

---

📋 Constraints:
- 1 ≤ nums.length ≤ 10⁵
- -10⁹ ≤ nums[i], x ≤ 10⁹
- nums is sorted in non-decreasing order
*/

package DSA_Diary.daily.d_2025_10_19;

public class Floor_and_Ceil_in_Sorted_Array_TUF {

    // Function to find floor and ceil of x in sorted array
    public int[] getFloorAndCeil(int[] nums, int x) {
        int n = nums.length;

        int floor = -1;
        int ceil = -1;

        int low = 0, high = n - 1;

        // Find floor
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] <= x) {
                floor = nums[mid];  // possible floor found
                low = mid + 1;      // try to find a larger one
            } else {
                high = mid - 1;
            }
        }

        // Reset pointers for ceil
        low = 0;
        high = n - 1;

        // Find ceil
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= x) {
                ceil = nums[mid];   // possible ceil found
                high = mid - 1;     // try to find a smaller one
            } else {
                low = mid + 1;
            }
        }

        return new int[]{floor, ceil};
    }
}

/*
🕒 Time Complexity (TC):
- Two binary searches → O(2 * log n) = O(log n)

💾 Space Complexity (SC):
- Constant extra space → O(1)
*/
