package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.LinkedList_Traversal;// LinkedList Traversal
// Difficulty: Basic   Accuracy: 80.99%   Submissions: 4K+   Points: 1
// Given a LinkedList `list` that contains integer elements. The task is to iterate through
// the given list and print its elements.

// Examples:

// Input: list = [1, 2, 3, 4]
// Output: 1 2 3 4
// Explanation: Simply iterate through the LinkedList and print the elements.

// Input: list = [3, 2, 1]
// Output: 3 2 1
// Explanation: Simply iterate through the LinkedList and print the elements.

import java.util.*;

// User function Template for Java
class Solution {
    public static void LinkedListTraversal(LinkedList<Integer> list) {
        // Iterate through the LinkedList and print each element
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
