package DSA_Diary.daily.d_2025_09_10;
/*
Find all subsequences with sum equals to K

Given an array arr[] of length n and a number k,
the task is to find all the subsequences of the array
with sum of its elements equal to k.

Note: A subsequence is a subset that can be derived from an array
by removing zero or more elements, without changing the order
of the remaining elements.

Examples:

Input: arr[] = [1, 2, 3], k = 3
Output: [ [1, 2], [3] ]
Explanation: All the subsequences of the given array are:
[ [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3], [] ]
Out of which only two subsequences have sum of their elements equal to 3.

Input: arr[] = [1, 2, 3], k = 7
Output: []
Explanation: Sum of all the elements of the array is 6, which is smaller
than the required sum, thus there are no subsequences with sum equal to 7.

Input: arr[] = [17, 18, 6, 11, 2, 4], k = 6
Output: [ [2, 4], [6] ]

Approach:
- The idea is to generate all possible subsequences of the given array.
- For every element in the array, we have two choices:
    1. Include it in the subsequence
    2. Exclude it from the subsequence
- Apply this recursively for every element starting from index 0.
- If the sum of the current subsequence is equal to k,
  store it in the result.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Printing_Subsequences_whose_sum_is_k {
    public static void main(String[] args) {

        int arr[] = {17, 18, 6, 11, 2, 4};
        int k = 6;
        ArrayList<ArrayList<Integer>> ans = subsequencesSumK(arr, k);
        for(ArrayList<Integer> i : ans) {
            for(Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> subsequencesSumK(int []arr, int k) {
        ArrayList<ArrayList<Integer>> res =new ArrayList<>();
        int n= arr.length;
        ArrayList<Integer> t = new ArrayList<>();
        f(0, arr, n, res,0 , k, t);
        return res;
    }

    static void f(int i, int[]arr, int n, ArrayList<ArrayList<Integer>> res,int sum, int k, ArrayList<Integer> t){
        if (i >= n) {
            if (sum == k) {
                res.add(new ArrayList<>(t));
            }
            return;
        }

        t.add(arr[i]);
        f(i+1, arr, n, res,sum+arr[i] , k, t);
        t.remove(t.size() - 1);
        f(i+1, arr, n, res,sum , k, t);
    }

    /*
    Time Complexity: O(n · 2ⁿ)
Space Complexity: O(n · 2ⁿ)
     */
}
