package DSA_Diary.daily.d_2025_10_11;

import java.util.ArrayList;
import java.util.Arrays;
/*
2 Sum - Pair Sum Closest to Target

Given an array arr[] of n integers and an integer target, find a pair of elements from the array such that the sum of the pair is closest to the given target.
Note:

Return the pair in sorted order.
If multiple pairs have the same closest sum, return the one with the maximum absolute difference (i.e., |a - b| is largest).
If no valid pair exists (i.e., array has fewer than 2 elements), return an empty array.
Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: Out of all the pairs, [5, 20] has sum = 25 which is closest to 25.

Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target.

Input: arr[] = [10], target = 10
Output: []
Explanation: As the input array has only 1 element, return an empty array.
 */
public class Sum_Pair_closest_to_target_DAY53_GFG160 {

    public ArrayList<Integer> sumClosest(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();

        if (arr.length < 2) return result; // no pair possible

        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int a = -1, b = -1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            int diff = Math.abs(target - sum);

            // 1️⃣ If found closer pair
            if (diff < minDiff) {
                minDiff = diff;
                a = arr[l];
                b = arr[r];
            }

            // 2️⃣ If same closeness, prefer max absolute difference pair
            else if (diff == minDiff) {
                if (Math.abs(arr[l] - arr[r]) > Math.abs(a - b)) {
                    a = arr[l];
                    b = arr[r];
                }
            }

            // 3️⃣ Move pointers
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else { // exact match
                break;
            }
        }

        if (a != -1) {
            result.add(a);
            result.add(b);
        }

        return result;

        /*
        ⚡ Time & Space Complexity
Time: O(n log n) (sorting + single pass)
Space: O(1) (constant extra space)
         */
    }

    public static void main(String[] args) {
        Sum_Pair_closest_to_target_DAY53_GFG160 obj = new Sum_Pair_closest_to_target_DAY53_GFG160();
        int[] arr = {5, 2, 7, 1, 4};
        int target = 10;
        System.out.println(obj.sumClosest(arr, target)); // [2, 7]
    }
}
