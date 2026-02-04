package DSA_Diary.daily.d_2026_02_04;
import java.util.HashMap;

/*
Largest Subarray with Equal Number of 0s and 1s

Problem Statement:
Given an array arr[] consisting of only 0s and 1s,
find the length of the longest contiguous subarray
that contains an equal number of 0s and 1s.

Examples:
Input:  arr = [1, 0, 1, 1, 1, 0, 0]
Output: 6

Input:  arr = [0, 0, 1, 1, 0]
Output: 4

Input:  arr = [0]
Output: 0
*/


public class Largest_subarray_of_0_and_1 {
    /*
         ------------------------------------------------
         Process 1: Very Naive Brute Force
         ------------------------------------------------
         Idea:
         - Generate all subarrays
         - Count 0s and 1s in each subarray
         - If counts are equal, update max length

         Time Complexity: O(n^3)
         Space Complexity: O(1)
         */
    public int maxLenBruteForce(int[] arr) {

        int n = arr.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int count0 = 0, count1 = 0;

                for (int k = i; k <= j; k++) {
                    if (arr[k] == 0) count0++;
                    else count1++;
                }

                if (count0 == count1) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    /*
     ------------------------------------------------
     Process 2: Improved Naive (Nested Loop + Prefix Sum)
     ------------------------------------------------
     Idea:
     - Treat 0 as -1 and 1 as +1
     - For every starting index, maintain cumulative sum
     - If sum becomes 0, subarray has equal 0s and 1s

     Time Complexity: O(n^2)
     Space Complexity: O(1)
     */
    public int maxLenPrefixNested(int[] arr) {

        int res = 0;

        for (int s = 0; s < arr.length; s++) {
            int sum = 0;

            for (int e = s; e < arr.length; e++) {
                sum += (arr[e] == 0) ? -1 : 1;

                if (sum == 0) {
                    res = Math.max(res, e - s + 1);
                }
            }
        }
        return res;
    }

    /*
     ------------------------------------------------
     Process 3: Optimal Approach (HashMap + Prefix Sum)
     ------------------------------------------------
     Idea:
     - Convert 0 → -1 and 1 → +1
     - Use prefix sum
     - If same prefix sum appears again, the subarray
       between those indices has sum 0
     - Store first occurrence of each prefix sum

     Time Complexity: O(n)
     Space Complexity: O(n)
     */
    public int maxLenOptimal(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {

            preSum += (arr[i] == 0) ? -1 : 1;

            // Subarray from index 0 to i
            if (preSum == 0) {
                res = i + 1;
            }

            // Subarray between two equal prefix sums
            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            }
            // Store first occurrence of prefix sum
            else {
                map.put(preSum, i);
            }
        }
        return res;
    }
}
