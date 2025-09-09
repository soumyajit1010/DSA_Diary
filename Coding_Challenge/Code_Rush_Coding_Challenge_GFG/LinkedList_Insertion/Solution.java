package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.LinkedList_Insertion;// LinkedList Insertion
// Difficulty: Basic   Accuracy: 83.12%   Submissions: 4K+   Points: 1
// Given an integer array arr[]. The task is to insert elements of given array to a LinkedList and return it.

// Example 1:
// Input: arr[] = [1, 2, 3, 4]
// Output: 1 2 3 4
// Explanation: Simply insert into LinkedList and return it.

// Example 2:
// Input: arr[] = [3, 2, 1]
// Output: 3 2 1
// Explanation: Simply insert into LinkedList and return it.

import java.util.*;

// User function Template for Java
class Solution {
    public static LinkedList<Integer> insertion(int arr[]) {
        // Create a new LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // Insert each element from array into the LinkedList
        for (int i : arr) {
            list.add(i);
        }

        // Return the populated LinkedList
        return list;
    }
}
