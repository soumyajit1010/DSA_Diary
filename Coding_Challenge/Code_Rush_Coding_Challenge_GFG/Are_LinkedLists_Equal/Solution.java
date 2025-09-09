package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Are_LinkedLists_Equal;
// Are LinkedLists Equal
// Difficulty: Basic
// Accuracy: 88.36%
// Submissions: 2K+
// Points: 1
//
// Given two integer LinkedLists ll1 and ll2, 
// you need to find if both the LinkedLists contain the same elements in the same order or not. 
//
// Examples:
//
// Input: ll1[] = [1, 2, 3, 4], ll2[] = [4, 3, 2, 1]
// Output: false
// Explanation: Both arrays are not same as they don't contain elements in the same order.
//
// Input: ll1[] = [5, 6, 7, 8, 9], ll2[] = [5, 6, 7, 8, 9]
// Output: true
// Explanation: Both arrays are same as they contain the same elements and in same order.

import java.util.*;

class Solution {
    public static boolean areEqual(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        // Simply use the built-in equals method which compares both size and element order
        return ll1.equals(ll2);
    }
}
