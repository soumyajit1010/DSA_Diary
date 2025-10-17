package DSA_Diary.daily.d_2025_10_17;

/*
Lower Bound
------------
Given a sorted array of integers 'nums' (in non-decreasing order) and an integer 'x',
find the lower bound of 'x'.

The lower bound algorithm finds the first (smallest) index in a sorted array
where the value at that index is greater than or equal to a given key 'x'.

If no such index exists, return the size of the array.

Examples:
Input: nums = [1, 2, 2, 3], x = 2
Output: 1
Explanation: Index 1 is the smallest index such that nums[1] >= 2

Input: nums = [3, 5, 8, 15, 19], x = 9
Output: 3
Explanation: Index 3 is the smallest index such that nums[3] >= 9

Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class Lower_Bound_TUF {
    public int lowerBound(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = n; // default to n if no element >= x is found

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= x) {
                ans = mid;     // possible answer found
                high = mid - 1; // look on left side for smaller index
            } else {
                low = mid + 1; // move right
            }
        }

        return ans;
    }
}
