package DSA_Diary.daily.d_2026_02_23;/*
216. Combination Sum III
Difficulty: Medium

Find all valid combinations of k numbers that sum up to n
such that:

1. Only numbers 1 through 9 are used.
2. Each number is used at most once.
3. Exactly k numbers must be chosen.
4. No duplicate combinations allowed.

Return all possible valid combinations.

-------------------------------------------------------------

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]

Example 3:
Input: k = 4, n = 1
Output: []

-------------------------------------------------------------
Approach: Backtracking

Idea:
- Try numbers from 1 to 9.
- Keep track of:
    - Remaining numbers to pick (k)
    - Remaining sum (n)
    - Start index (to avoid duplicates)
    - Current combination list
- If k == 0 and remainingSum == 0 → valid combination.
- Use pruning to stop early if current number > remainingSum.
-------------------------------------------------------------
*/

import java.util.*;

class Sum {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(k, n, 1, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int k,
                           int remainingSum,
                           int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Base Case: Valid combination found
        if (k == 0 && remainingSum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Invalid case
        if (k == 0 || remainingSum < 0)
            return;

        // Try numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {

            // Pruning: If number exceeds remaining sum, stop
            if (i > remainingSum)
                break;

            current.add(i);

            backtrack(k - 1,
                    remainingSum - i,
                    i + 1,
                    current,
                    result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    /*
    Time Complexity:
    O(C(9, k))  ≈ O(2^9) worst case (since max numbers = 9)
    Very small constant.

    Space Complexity:
    O(k) for recursion stack + current list.
    */
}