package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Rotate_LinkedList_By_K;
// Rotate LinkedList By K
// Difficulty: Basic
// Given a LinkedList `ll` and an integer `k`, rotate the list to the right by `k` positions.
//
// Example 1:
// Input: ll = [9, 8, 7, 6, 5, 4, 4], k = 2
// Output: [4, 4, 9, 8, 7, 6, 5]
//
// Example 2:
// Input: ll = [99, 6, 33], k = 4
// Output: [33, 99, 6]

import java.util.*;

class Solution {
    public static void rotateByK(LinkedList<Integer> ll, int k) {
        // Handle edge cases where rotation is not needed
        if (ll == null || ll.size() == 0 || k == 0)
            return;

        int n = ll.size();
        k = k % n; // To handle cases where k > size

        // Perform rotation k times
        for (int i = 0; i < k; i++) {
            int last = ll.removeLast();  // Remove last element
            ll.addFirst(last);           // Add it to the front
        }

        // No need to print as per problem statement
    }
}
