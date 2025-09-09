package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Java_Streams_Filter;/*
Java Streams Filter
Difficulty: Basic
Accuracy: 88.43%
Submissions: 4K+
Points: 1

Problem Statement:
Given an integer array arr[]. The task is to find the maximum odd element.

Examples:

Input: 1 2 3 4
Output: 3
Explanation: Odd elements are 1 and 3. The max is 3.

Input: 3 2 1
Output: 3
Explanation: Odd elements are 3 and 1. The max is 3.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/

// User function Template for Java
class Solution {
    public static int filterUsingStreams(int[] arr) {
        // Use filter() to get only odd elements then apply max().getAsInt()
        return java.util.Arrays.stream(arr)
                .filter(x -> x % 2 != 0)
                .max()
                .getAsInt();
    }
}
