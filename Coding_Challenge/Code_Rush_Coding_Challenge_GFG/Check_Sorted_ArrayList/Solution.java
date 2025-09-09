package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Check_Sorted_ArrayList;/*
Check Sorted ArrayList
Difficulty: Easy  Accuracy: 48.38%  Submissions: 5K+  Points: 2

Given an ArrayList list, check if it is sorted or not. 
It should be in sorted ascending or descending order.

Examples:

Input: list = [1, 3, 56, 99]
Output: Sorted
Explanation: The given arraylist is sorted in ascending order.

Input: list = [13, 12, 11, 11]
Output: Sorted
Explanation: The given arraylist is sorted in descending order.
*/

import java.util.*;

class Solution {
    public static boolean isSorted(ArrayList<Integer> list) {
        if (list.size() <= 1) return true;

        boolean ascending = true, descending = true;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) ascending = false;
            if (list.get(i) > list.get(i - 1)) descending = false;
        }

        return ascending || descending;
    }
}
