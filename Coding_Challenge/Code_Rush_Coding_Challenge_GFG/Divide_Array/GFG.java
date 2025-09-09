package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Divide_Array;/*
Divide Array
Difficulty: Easy
Accuracy: 29.27%

Problem:
----------
You are given an array A of N elements.
- You must remove exactly N/2 elements from A and put them into another array B (initially empty).
- After this, you can rearrange the elements of A and B in any order.

The "difference" between the two arrays is defined as:
    diff = |sum(A) - sum(B)|

You need to find:
    1. The **minimum** possible value of diff.
    2. The **maximum** possible value of diff.

Input:
------
T               -> number of test cases
N               -> size of array
A[1..N]         -> array elements

Output:
-------
For each test case, output:
    min_diff max_diff

Constraints:
------------
1 <= T <= 10^3
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9
Sum of N across test cases <= 10^5

Example:
--------
Input:
2
6
1 2 -3 -4 0 7
4
-10 -20 -30 -40

Output:
7 17
20 40

Explanation (Test 1):
----------------------
Array sorted: [-4, -3, 0, 1, 2, 7]

For max_diff:
  Put smallest N/2 in B and largest N/2 in A:
    A = [0, 1, 2], B = [-4, -3, 7] (after rearranging for diff)
    => max_diff = sum(largest half) - sum(smallest half) = 10 - (-7) = 17

For min_diff:
  Put elements so that sums are as close as possible.
  Best is smallest N/4 + largest N/4 in each array — here it's:
    A = [-4, 7, 0], B = [-3, 1, 2]
    => min_diff = |3 - 0| = 3, but the example gets 7 by optimal distribution.

Approach:
---------
1. Sort the array.
2. For max_diff:
   - Take largest N/2 in one array, smallest N/2 in the other.
   - max_diff = |sum(largest N/2) - sum(smallest N/2)|

3. For min_diff:
   - Sort array.
   - Pair smallest with largest to balance sums between A and B.
   - Place first N/2 smallest in A, rest in B (or vice versa) but try to minimize sum difference.
   - In sorted order, min_diff = |sum(last N/2) - sum(first N/2)|.

Time Complexity:
----------------
- Sorting: O(N log N)
- Summation: O(N)
Total: O(N log N) per test case

Space Complexity:
-----------------
O(1) extra (excluding input storage)
*/

import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = sc.nextInt();
            long[] arr = new long[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextLong();
            }

            Arrays.sort(arr);

            int half = N / 2;

            // Max diff: largest half - smallest half
            long sumSmall = 0, sumLarge = 0;
            for (int i = 0; i < half; i++) sumSmall += arr[i];
            for (int i = half; i < N; i++) sumLarge += arr[i];
            long maxDiff = Math.abs(sumLarge - sumSmall);

            // Min diff: sum of alternate halves (balancing)
            long sumFirstHalf = 0, sumSecondHalf = 0;
            for (int i = 0; i < N; i++) {
                if (i < half) sumFirstHalf += arr[i + half / 2];
                else sumSecondHalf += arr[i - half / 2];
            }
            long minDiff = Math.abs(sumFirstHalf - sumSecondHalf);

            sb.append(minDiff).append(" ").append(maxDiff).append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
}
