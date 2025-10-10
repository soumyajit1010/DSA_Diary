/*
77. Combinations
Medium

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

Example 2:
Input: n = 1, k = 1
Output: [[1]]
*/

package DSA_Diary.daily.d_2025_10_10;

import java.util.ArrayList;
import java.util.List;

public class Combinations_leetcode {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), list);
        return list;
    }

    public static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination complete
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choose next number
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k - 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
