package DSA_Diary.daily.d_2025_09_09;
/*
78. Subsets
Medium

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

--------------------------------------------------------
Approach: Recursion + Backtracking
--------------------------------------------------------
*/

import java.util.*;

public class leetcode_Subsets_Subsequences {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> array = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        f(0, arr, n, array, nums);
        return array;
    }

    public void f(int ind, ArrayList<Integer> arr, int n, List<List<Integer>> array, int[] nums) {
        if (ind >= n) {
            array.add(new ArrayList<>(arr)); // add a copy
            return;
        }

        // include nums[ind]
        arr.add(nums[ind]);
        f(ind + 1, arr, n, array, nums);

        // backtrack
        arr.remove(arr.size() - 1);

        // exclude nums[ind]
        f(ind + 1, arr, n, array, nums);
    }
}

/*
--------------------------------------------------------
Time Complexity:
- There are 2^n subsets (each element can be included or excluded).
- For each subset, we may spend up to O(n) time (copying the list).
=> Total: O(n * 2^n)

Space Complexity:
- Recursion depth = O(n)
- Output list stores all subsets = O(n * 2^n)
=> Total: O(n * 2^n)
--------------------------------------------------------
*/
