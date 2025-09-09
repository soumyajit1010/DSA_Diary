package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Binary_Search_Method;/*
Binary Search Method
Difficulty: Basic | Accuracy: 55.39%

Question:
Given a sorted integer array arr[] and an integer element k.
The task is to check if the element is present in the array or not and return the index.

Example 1:
Input: arr[] = [1, 2, 3, 4, 6], k = 6
Output: 4
Explanation: 6 is present at index 4 (0-based indexing).

Example 2:
Input: arr[] = [1, 3, 4, 5, 6], k = 2
Output: -1
Explanation: 2 is not present in the array, so return -1.

User Task:
You need to complete the function binarySearchArray that takes an array arr and an integer k, and returns the index of k if present, else returns -1.
*/

class Solution {
    public static int binarySearchArray(int arr[], int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // if element not found
    }
}
