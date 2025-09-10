package DSA_Diary.daily.d_2025_09_10;

import java.util.ArrayList;
/*
Question:
---------
Find any one subsequence of an array whose sum is equal to K.

Definition:
-----------
- A subsequence is a sequence derived by removing zero or more elements
  without changing the order of the remaining elements.
- Here, instead of finding ALL subsequences with sum = K,
  we stop after printing the FIRST one found.

Example:
--------
Input: arr = [1, 2, 3], k = 3
Output: [1, 2]    // (or [3], since both are valid subsequences)

Approach:
---------
- Use recursion with backtracking.
- At each index, we have two choices:
  1. Include arr[index] in the current subsequence.
  2. Exclude arr[index] from the current subsequence.
- Keep track of the current sum.
- If sum == K when index == n, print the subsequence and stop.

Time Complexity:
----------------
O(2^n) in the worst case
(because each element has 2 choices: pick or not pick).
But since we stop after finding the first valid subsequence,
in practice it may terminate much earlier.

Space Complexity:
-----------------
O(n) for the recursion call stack + O(n) for storing the current subsequence.
So total = O(n).
*/
public class PrintOneSubsequenceSumK {

    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int n = arr.length;
        int k = 2;

        ArrayList<Integer> ds = new ArrayList<>();
        boolean found = printOne(0, ds, 0, k, arr, n);

        if (!found) {
            System.out.println("No subsequence found");
        }
    }

    // Function to print only one subsequence with sum = k
    static boolean printOne(int index, ArrayList<Integer> ds, int sumSoFar, int k, int[] arr, int n) {
        // base case
        if (index == n) {
            if (sumSoFar == k) {
                System.out.println(ds);
                return true; // found one subsequence
            }
            return false;
        }

        // pick the current element
        ds.add(arr[index]);
        sumSoFar += arr[index];
        if (printOne(index + 1, ds, sumSoFar, k, arr, n)) return true;

        // backtrack (remove the picked element)
        sumSoFar -= arr[index];
        ds.remove(ds.size() - 1);

        // not pick the current element
        if (printOne(index + 1, ds, sumSoFar, k, arr, n)) return true;

        return false;
    }
}
