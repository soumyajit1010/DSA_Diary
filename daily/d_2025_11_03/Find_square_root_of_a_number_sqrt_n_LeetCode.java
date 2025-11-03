/*
69. Sqrt(x)
---------------------
Given a non-negative integer x, return the square root of x rounded down
to the nearest integer. The returned integer should be non-negative as well.

You must NOT use any built-in exponent function or operator.
(For example, do not use pow(x, 0.5) in C++ or x ** 0.5 in Python.)

Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to
the nearest integer, 2 is returned.
*/


package DSA_Diary.daily.d_2025_11_03;

public class Find_square_root_of_a_number_sqrt_n_LeetCode {

    // ✅ Approach 1: Using built-in Math.sqrt() (not allowed in LeetCode but for reference)
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    // ✅ Approach 2: Brute Force
    // Check every number from 0 to x until i*i exceeds x
    // Time Complexity: O(√x)
    // Space Complexity: O(1)
    public int mySqrt_2(int x) {
        int ans = 0;
        for (int i = 0; i <= x; i++) {
            long sq = (long) i * i; // Use long to prevent integer overflow
            if (sq <= x) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    // ✅ Approach 3: Binary Search (Optimized)
    // Use binary search to find the integer part of the square root
    // Time Complexity: O(log x)
    // Space Complexity: O(1)
    public int mySqrt_3(int x) {
        if (x < 2) return x;

        int low = 1, high = x / 2, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long sq = (long) mid * mid;

            if (sq == x) return mid;
            else if (sq < x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
