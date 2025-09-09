package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Maximum_Neighbours_In_ArrayList;/*
Maximum Neighbours In ArrayList
Difficulty: Easy
Accuracy: 75.84%
Submissions: 5K+
Points: 2

Given an integer ArrayList arr[]. The task is to find the maximum for every adjacent pair in the ArrayList.

Examples:

Input: 1 2 2 3 4 5
Output: 2 2 3 4 5
Explanation: Maximum of arr[0] and arr[1] is 2, that of arr[1] and arr[2] is 2, ... and so on. For last two elements, maximum is 5.

Input: 5 5
Output: 5
Explanation: We only have two elements so max of 5 and 5 is 5 only.
*/

import java.util.*;

class Solution {
    public static ArrayList<Integer> maxNeighbour(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.size() - 1; i++) {
            int max = Math.max(arr.get(i), arr.get(i + 1));
            result.add(max);
        }

        return result;
    }
}

