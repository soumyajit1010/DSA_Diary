package DSA_Diary.daily.d_2025_09_10;
/*
Problem: Count Subsequences with Sum Equals to K

Given an array arr[] of length n and a number k,
the task is to count all the subsequences of the array
such that the sum of its elements is equal to k.

Note: A subsequence is a subset that can be derived from an array
by removing zero or more elements, without changing the order
of the remaining elements.

Examples:

Input: arr[] = [1, 2, 3], k = 3
Output: 2
Explanation: Subsequences with sum 3 are [1, 2] and [3].

Input: arr[] = [1, 2, 3], k = 7
Output: 0
Explanation: Sum of all elements = 6 < 7, so no subsequence exists.

Input: arr[] = [17, 18, 6, 11, 2, 4], k = 6
Output: 2
Explanation: Subsequences are [6] and [2, 4].

------------------------------------------------------
Approach:
- Use recursion to generate all subsequences.
- For each element, we have two choices:
  1. Include it in the current subsequence (add to sum).
  2. Exclude it from the subsequence.
- At the end (i == n), check if sum == k.
- Count all valid subsequences.

------------------------------------------------------
Time Complexity:
- O(2^n) → because each element has two choices (include/exclude).
- We must explore all subsequences.

Space Complexity:
- O(n) → recursion stack depth in the worst case.
- No extra space used (not storing subsequences).

------------------------------------------------------
*/
public class Count_Subsequences_SumK {
    public static void main(String[] args) {
        int arr[] = {17, 18, 6, 11, 2, 4};
        int k = 6;
        int count = countSubsequencesSumK(0, 0, arr, k);
        System.out.println("Count = " + count);
    }

    static int countSubsequencesSumK(int i, int sum, int[] arr, int k) {
        if (i == arr.length) {
            return (sum == k) ? 1 : 0;
        }

        // include current element
        int left = countSubsequencesSumK(i + 1, sum + arr[i], arr, k);

        // exclude current element
        int right = countSubsequencesSumK(i + 1, sum, arr, k);

        return left + right;
    }
}
