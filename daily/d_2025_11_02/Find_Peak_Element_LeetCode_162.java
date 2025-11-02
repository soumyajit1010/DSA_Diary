/*
💡 162. Find Peak Element

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.
In other words, an element is always considered to be strictly greater
than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.

📘 Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return index 2.

📘 Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index 1 (peak = 2) or index 5 (peak = 6).
*/

package DSA_Diary.daily.d_2025_11_02;

public class Find_Peak_Element_LeetCode_162 {

    // 🔹 Brute Force Approach
    // Check every element to find a peak element.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int findPeakElementBruteForce(int[] nums) {
        int n = nums.length;

        // If there is only one element
        if (n == 1) return 0;

        // Check first and last elements separately
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        // Check all middle elements
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return -1; // No peak found (theoretically impossible)
    }


    // 🔹 Optimized Approach (Binary Search)
    // Use binary search to find a peak element.
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int findPeakElementOptimized(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is smaller than next element,
            // then there is a peak on the right half
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                // Otherwise, the peak lies on the left half (including mid)
                high = mid;
            }
        }

        return low; // low == high -> peak index
    }

    // Example Test
    public static void main(String[] args) {
        Find_Peak_Element_LeetCode_162 obj = new Find_Peak_Element_LeetCode_162();
        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        System.out.println("Brute Force Peak Index: " + obj.findPeakElementBruteForce(nums));
        System.out.println("Optimized Peak Index: " + obj.findPeakElementOptimized(nums));
    }
}
