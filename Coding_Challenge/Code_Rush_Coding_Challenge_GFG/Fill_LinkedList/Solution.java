package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Fill_LinkedList;// Fill LinkedList
// Difficulty: Basic
// Accuracy: 90.46%
// Submissions: 2K+
// Points: 1
//
// You are given an integer LinkedList ll, you are also given a value k.
// You need to fill ll with k.
//
// Examples:
//
// Input: ll = [1, 2, 3, 4, 5], k = 67
// Output: 67 67 67 67 67
//
// Input: ll = [7], k = 99
// Output: 99

// User function Template for Java
import java.util.*;

class Solution {
    public static void fillLinkedList(LinkedList<Integer> ll, int k) {
        // Iterate through the list and set each element to k
        for (int i = 0; i < ll.size(); i++) {
            ll.set(i, k);
        }
    }
}
