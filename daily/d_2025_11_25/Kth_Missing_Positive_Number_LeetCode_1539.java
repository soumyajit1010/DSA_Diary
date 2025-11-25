/*
 * 1539. Kth Missing Positive Number
 * --------------------------------
 * Given a sorted array `arr` of positive integers in strictly increasing order,
 * and an integer `k`, return the k-th positive integer missing from this array.
 *
 * Example 1:
 * Input: arr = [2,3,4,7,11], k = 5
 * Missing numbers: [1,5,6,8,9,10,12...]
 * Output: 9
 *
 * Example 2:
 * Input: arr = [1,2,3,4], k = 2
 * Missing numbers: [5,6,7...]
 * Output: 6
 *
 * -----------------------------------------------
 * Approaches:
 *
 * 1. Brute Force (Using List)
 *    Time: O(n + k)
 *    Space: O(n + k)
 *
 * 2. Improved Linear Scan
 *    Time: O(n)
 *    Space: O(1)
 *
 * 3. Optimal — Binary Search
 *    Time: O(log n)
 *    Space: O(1)
 */

package DSA_Diary.daily.d_2025_11_25;

import java.util.ArrayList;

public class Kth_Missing_Positive_Number_LeetCode_1539 {

    // ------------------------------------------------------------
    // 1️⃣ Brute Force Method — Using ArrayList (Your logic corrected)
    // ------------------------------------------------------------
    // Time Complexity: O(n + k)
    // Space Complexity: O(n + k)
    public int bruteForceFindKthPositive(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = arr[arr.length - 1];
        int c = 0;

        for (int i = 1; i <= max + k; i++) {
            if (c < arr.length && i == arr[c]) {
                c++;
            } else {
                list.add(i);
            }
        }
        return list.get(k - 1); // FIXED (k-1)
    }

    // ------------------------------------------------------------
    // 2️⃣ Better Linear Scan — No extra space
    // ------------------------------------------------------------
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int linearFindKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int previous = 0;

        for (int value : arr) {
            int gap = value - previous - 1;
            if (missingCount + gap >= k) {
                return previous + (k - missingCount);
            }
            missingCount += gap;
            previous = value;
        }

        return arr[arr.length - 1] + (k - missingCount);
    }

    // ------------------------------------------------------------
    // 3️⃣ Optimal Approach — Binary Search
    // ------------------------------------------------------------
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Missing numbers until arr[mid]
            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Final formula: kth missing = k + high + 1
        return k + high + 1;
    }
}


// ===========================================================
// Clean LeetCode Submission Class
// ===========================================================
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return k + high + 1;
    }
}
