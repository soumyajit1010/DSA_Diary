package DSA_Diary.daily.d_2025_09_11;

import java.util.ArrayList;
import java.util.List;
/*
LeetCode Problem: Combination Sum

Question:
---------------
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen
numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen
numbers is different.

Input:
candidates = [2,3,6,7], target = 7
Output:
[ [2,2,3], [7] ]

Explanation:
- We can use numbers multiple times.
- [2,2,3] and [7] are the only unique ways to sum to 7.

Constraints:
1 <= candidates.length <= 30
2 <= candidates[i] <= 40
1 <= target <= 40
All elements of candidates are distinct.

---------------
Approach:
- Use recursion + backtracking.
- At each index, we have two choices:
    1. Include the current number (stay on same index because reuse allowed).
    2. Exclude the current number (move to next index).
- Stop when:
    - target == 0 → valid combination.
    - target < 0 or index == n → invalid path.

---------------
Time Complexity:
- Worst case, we explore all possible combinations.
- Each number can be chosen up to target / min(candidates[i]) times.
- Rough upper bound: O(2^n) but practically smaller since pruning happens.
- For candidates length n and target T:
  TC ≈ O(n^(T / min(candidates))).

Space Complexity:
- Recursion depth = O(T / min(candidates)).
- Auxiliary space for storing results.
- SC = O(T) (for recursion stack) + O(K) (for storing results, K = number of valid combinations).
*/
public class LeetCode_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        f(0, arr, candidates, target, a);
        return arr;
    }

    public static void f(int i, List<List<Integer>> arr, int[] candidates, int target, ArrayList<Integer> a) {
        if (target == 0) {   // ✅ valid combination found
            arr.add(new ArrayList<>(a));
            return;
        }
        if (i == candidates.length) return;

        if (target >= candidates[i]) {   // ✅ allow equal also
            a.add(candidates[i]);
            f(i, arr, candidates, target - candidates[i], a); // stay at same i (reuse allowed)
            a.remove(a.size() - 1);
        }

        f(i + 1, arr, candidates, target, a);  // move to next candidate
    }
}
