package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Java_Streams_Average;/*
Java Streams Average
Difficulty: Basic
Accuracy: 85.05%
Submissions: 4K+
Points: 1

Problem Statement:
Given an integer array arr[]. The task is to find the average of the array using Java Streams.

Note: Average is the sum of all elements divided by the number of elements.

Examples:

Input: 1 2 3 4
Output: 2.5
Explanation: 1+2+3+4 = 10. 10/4 = 2.5

Input: 3 2 1
Output: 2.0
Explanation: 3+2+1 = 6. 6/3 = 2.0

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/

// User function Template for Java
class Solution {
    public static double avgUsingStreams(int[] arr) {
        // Use stream().average().getAsDouble()
        return java.util.Arrays.stream(arr).average().getAsDouble();
    }
}
