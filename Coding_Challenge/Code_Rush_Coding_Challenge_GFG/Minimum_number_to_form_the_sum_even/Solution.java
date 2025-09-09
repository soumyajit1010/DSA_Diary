package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Minimum_number_to_form_the_sum_even;/*
Minimum number to form the sum even
Difficulty: Basic
Accuracy: 55.02%
Submissions: 21K+
Points: 1

Problem Statement:
Given an array arr[] of size N, the task is to add the minimum number to the array so that the sum of the array becomes even.

Example 1:
Input: N = 8
arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
Output:  0
Explanation: Sum of array is 36, so we add minimum number 0 to make the sum even.

Example 2:
Input: N = 9
arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9}
Output:  1
Explanation: Sum of array is 45 (odd), so we need to add 1 to make it even.

Your Task:
This is a function problem. You don't need to take any input, as it is already accomplished by the driver code.
You just need to complete the function minNum() that takes array A and integer N as parameters and returns the 
minimum number required to the array so that the sum becomes even.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/

// User function Template for Java
class Solution {
    long minNum(long A[], int N) {
        long sum = 0;
        
        // Calculate the sum of all elements
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }
        
        // If sum is even, return 0; else return 1
        if (sum % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
