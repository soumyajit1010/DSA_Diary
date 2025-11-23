/*
1283. Find the Smallest Divisor Given a Threshold
-------------------------------------------------
Given an integer array nums and an integer threshold, choose a positive integer
divisor. Divide every element in nums by the divisor and take the ceiling of each.
Find the smallest divisor such that the sum of these values is <= threshold.

Example:
Input: nums = [1,2,5,9], threshold = 6
Output: 5

Approach:
Binary Search on divisor range [1 ... max(nums)].
For each divisor, calculate sum of ceilings.
If sum <= threshold → try smaller divisor.
Else → increase divisor.

Time Complexity: O(N * log(max(nums)))
Space Complexity: O(1)
*/

package DSA_Diary.daily.d_2025_11_23;

public class Find_the_smallest_divisor_LeetCode_1283 {

    // Helper function to compute sum of ceil(nums[i] / div)
    private int sumByDivisor(int[] nums, int div) {
        int sum = 0;
        for (int x : nums) {
            sum += (int) Math.ceil((double) x / div);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        // Search space: 1 to max element
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int x : nums) {
            high = Math.max(high, x);
        }

        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int sum = sumByDivisor(nums, mid);

            if (sum <= threshold) {
                high = mid - 1;  // try smaller divisor
            } else {
                low = mid + 1;  // need bigger divisor
            }
        }

        return low;  // smallest valid divisor
    }
}
