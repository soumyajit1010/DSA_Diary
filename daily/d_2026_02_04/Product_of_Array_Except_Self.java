package DSA_Diary.daily.d_2026_02_04;

import java.util.Arrays;


/*
Product of Array Except Self

Problem Statement:
Given an array arr[] of n integers, construct a product array res[]
(of the same size) such that res[i] is equal to the product of all
the elements of arr[] except arr[i].

Example:
Input:  arr = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]

Explanation:
res[0] = 3 * 5 * 6 * 2 = 180
res[1] = 10 * 5 * 6 * 2 = 600
res[2] = 10 * 3 * 6 * 2 = 360
res[3] = 10 * 3 * 5 * 2 = 300
res[4] = 10 * 3 * 5 * 6 = 900
*/


public class Product_of_Array_Except_Self {

    /*
    ------------------------------------------------
    Process 1: Naive Approach (Nested Loops)
    ------------------------------------------------
    Idea:
    - For each index i, multiply all elements except arr[i]

    Time Complexity: O(n^2)
    Space Complexity: O(n)  (for result array)
    */
    public int[] productExceptSelfNaive(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    res[i] *= arr[j];
                }
            }
        }
        return res;
    }

    /*
    ------------------------------------------------
    Process 2: Better Approach (Prefix & Suffix Array)
    ------------------------------------------------
    Idea:
    - pref[i]  = product of elements before index i
    - suff[i]  = product of elements after index i
    - res[i] = pref[i] * suff[i]

    Time Complexity: O(n)
    Space Complexity: O(n)
    */
    public int[] productExceptSelfPrefixSuffix(int[] arr) {
        int n = arr.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int[] res = new int[n];

        // Prefix product
        pref[0] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] * arr[i - 1];
        }

        // Suffix product
        suff[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * arr[i + 1];
        }

        // Result
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }

    /*
    ------------------------------------------------
    Process 3: Efficient Approach (Using Total Product & Zeros)
    ------------------------------------------------
    Idea:
    - Count number of zeros
    - If no zero: res[i] = totalProduct / arr[i]
    - If one zero: only that index gets product of non-zero elements
    - If more than one zero: all results are zero

    Time Complexity: O(n)
    Space Complexity: O(n)
    */
    public int[] productExceptSelfEfficient(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, 0);

        int product = 1;
        int zeroCount = 0;
        int zeroIndex = -1;

        // Count zeros and compute product of non-zero elements
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            } else {
                product *= arr[i];
            }
        }

        // No zero
        if (zeroCount == 0) {
            for (int i = 0; i < n; i++) {
                res[i] = product / arr[i];
            }
        }
        // One zero
        else if (zeroCount == 1) {
            res[zeroIndex] = product;
        }
        // More than one zero -> all values remain 0

        return res;
    }
}
