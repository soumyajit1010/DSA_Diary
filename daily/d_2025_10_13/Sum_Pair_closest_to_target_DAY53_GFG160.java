package DSA_Diary.daily.d_2025_10_13;

import java.util.ArrayList;
import java.util.Arrays;

/*
revision--> d_2025_10_11


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

    //[Naive Approach] Explore all possible pairs - O(n^2) Time and O(1) Space
    static ArrayList<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;

        ArrayList<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        // Generating all possible pairs
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                int currSum = arr[i] + arr[j];
                int currDiff = Math.abs(currSum - target);

                // if currDiff is less than minDiff, it indicates
                // that this pair is closer to the target
                if (currDiff < minDiff) {
                    minDiff = currDiff;
                    res = new ArrayList<>(Arrays.asList(
                            Math.min(arr[i], arr[j]),
                            Math.max(arr[i], arr[j])
                    ));
                }

                // if currDiff is equal to minDiff, find the one with
                // largest absolute difference
                else if (currDiff == minDiff &&
                        (res.get(1) - res.get(0)) < Math.abs(arr[i] - arr[j])) {
                    res = new ArrayList<>(Arrays.asList(
                            Math.min(arr[i], arr[j]),
                            Math.max(arr[i], arr[j])
                    ));
                }
            }
        }
        return res;
    }


    //[Expected Approach] Two Pointer Technique - O(n × logn + n) Time and O(1) Space

    static ArrayList<Integer> sumClosest2(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        int left = 0, right = n - 1;

        while (left < right) {
            int currSum = arr[left] + arr[right];
            int currDiff = Math.abs(target - currSum);

            // check if this pair is closer than the closest
            // pair so far
            if (currDiff < minDiff) {
                minDiff = currDiff;
                res = new ArrayList<>(Arrays.asList(arr[left], arr[right]));
            }

            // if this pair has sum = target, return it immediately
            if (currSum == target)
                return new ArrayList<>(Arrays.asList(arr[left], arr[right]));

                // if this pair has less sum, move to greater values
            else if (currSum < target)
                left++;

                // if this pair has more sum, move to smaller values
            else
                right--;
        }

        return res;
    }
}
