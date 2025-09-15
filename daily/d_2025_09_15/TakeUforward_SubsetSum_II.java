package DSA_Diary.daily.d_2025_09_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Subsets II
----------------------
Medium | Backtracking

Given an integer array nums, which can have duplicate entries,
provide the power set (all possible subsets).

Duplicate subsets must not exist in the solution set.
Return the answer in any order.

---------------------------------
Examples:

Input : nums = [1, 2, 2]
Output : [ [], [1], [1, 2], [1, 2, 2], [2], [2, 2] ]

Input : nums = [1, 2]
Output : [ [], [1], [2], [1, 2] ]

---------------------------------
Constraints:
- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10

---------------------------------
*/

public class TakeUforward_SubsetSum_II {
    public void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds)); // add current subset

        for (int i = ind; i < nums.length; i++) {
            // skip duplicates
            if (i > ind && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1); // backtrack
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // sort to group duplicates
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }
}
