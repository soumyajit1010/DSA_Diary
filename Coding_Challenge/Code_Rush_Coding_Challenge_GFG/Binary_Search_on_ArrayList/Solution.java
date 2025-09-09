package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Binary_Search_on_ArrayList;// Binary Search on ArrayList
// Difficulty: Basic
// Accuracy: 77.43%
// Submissions: 3K+
// Points: 1

/*
Given a sorted integer ArrayList and an integer element k. 
The task is to check if the element is present in the ArrayList or not and return the index.

Examples:

Input: list[] = [1, 2, 3, 4, 6], k = 6
Output: 4
Explanation: Since 6 is present in the list at index 4 (0-based indexing), so output is 4.

Input: list[] = [1, 3, 4, 5, 6], k = 2
Output: -1
Explanation: Since 2 is not present in the list, so output is -1.
*/

import java.util.ArrayList;

class Solution {
    public static int binarySearchAL(ArrayList<Integer> list, int k) {
        // Binary search implementation for sorted ArrayList
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == k) {
                return mid;
            } else if (list.get(mid) < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If k not found, return -1
        return -1;
    }
}
