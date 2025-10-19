package DSA_Diary.daily.d_2025_10_19;
/*
Problem: Upper Bound in a Sorted Array

You are given a **sorted array** of integers `nums` and an integer `x`.
Write a program to find the **upper bound** of `x`.

Definition:
The **upper bound** of `x` is defined as the **smallest index `i`** such that `nums[i] > x`.
If no such index exists, return the size of the array.

Input:
- n = length of nums
- nums = sorted array of integers
- x = integer to find upper bound for

Output:
- smallest index i such that nums[i] > x

Examples:

1. Input: nums = [1,2,2,3], x = 2
   Output: 3
   Explanation: Index 3 is the first element greater than 2.

2. Input: nums = [3,5,8,15,19], x = 9
   Output: 3
   Explanation: Index 3 (value 15) is the first element greater than 9.

Constraints:
- nums is sorted in non-decreasing order
- 1 <= n <= 10^5
- -10^9 <= nums[i], x <= 10^9
*/

public class Upper_Bound_TUF {

    // Function to find the upper bound of x in sorted array nums
    public int upperBound(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n; // default to n if no element > x is found

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > x) {
                ans = mid;       // possible upper bound found
                high = mid - 1;  // search on left side for smaller index
            } else {
                low = mid + 1;   // search on right side
            }
        }

        return ans;
    }
}

/*
Time Complexity (TC):
- Each iteration halves the search space → O(log n)
- Total: O(log n)

Space Complexity (SC):
- Only a few variables are used → O(1)
*/