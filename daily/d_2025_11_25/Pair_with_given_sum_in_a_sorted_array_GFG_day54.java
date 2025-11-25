package DSA_Diary.daily.d_2025_11_25;

/*
    ❓ Problem: Pair with Given Sum in a Sorted Array (GFG)

    You are given a sorted array arr[] and an integer target.
    Your task is to count the number of pairs (i, j) such that:
        arr[i] + arr[j] == target
        and i < j

    Example:
        Input: arr = [-1, 1, 5, 5, 7], target = 6
        Output: 3

        Pairs: {1,5}, {1,5}, {-1,7}

    Note:
    - Array is sorted.
    - Pairs must come from different indices.

    --------------------------------------------------------------
    ✅ BRUTE FORCE SOLUTION
    Time Complexity: O(n²)
    Space Complexity: O(1)
    --------------------------------------------------------------
*/

public class Pair_with_given_sum_in_a_sorted_array_GFG_day54 {

    // Brute Force – O(n²)
    int countPairs(int arr[], int target) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    res++;
                }
            }
        }

        return res;
    }

    /*
        --------------------------------------------------------------
        ✅ OPTIMIZED TWO-POINTER SOLUTION
        Time Complexity: O(n)
        Space Complexity: O(1)
        --------------------------------------------------------------
        Handles duplicates efficiently:
        - If arr[left] + arr[right] == target
          → count multiplicities of both sides
    */

    static int countPairs2(int[] arr, int target) {
        int res = 0;
        int left = 0, right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
            else {
                int ele1 = arr[left], ele2 = arr[right];
                int cnt1 = 0, cnt2 = 0;

                // Count occurrences of arr[left]
                while (left <= right && arr[left] == ele1) {
                    cnt1++;
                    left++;
                }

                // Count occurrences of arr[right]
                while (left <= right && arr[right] == ele2) {
                    cnt2++;
                    right--;
                }

                // If elements are equal, use nC2
                if (ele1 == ele2) {
                    res += (cnt1 * (cnt1 - 1)) / 2;
                } else {
                    res += (cnt1 * cnt2);
                }
            }
        }
        return res;
    }
}
