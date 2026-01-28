package DSA_Diary.daily.d_2026_01_28;/*
Q3. Find All Numbers Disappeared in an Array

Problem Statement:
Given an integer array nums of size n where each element is in the range [1, n],
find all the numbers in the range [1, n] that do not appear in nums.

Return the missing numbers as a list.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
*/

import java.util.*;

class Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        boolean[] present = new boolean[n + 1]; // to mark presence of numbers

        // Mark numbers that appear in the array
        for (int i = 0; i < n; i++) {
            present[nums[i]] = true;
        }

        List<Integer> result = new ArrayList<>();

        // Collect numbers that are missing
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
