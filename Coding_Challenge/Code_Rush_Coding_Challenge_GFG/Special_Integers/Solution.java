package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Special_Integers;/*
Special Integers
Difficulty: Basic
Accuracy: 50.99%
Points: 1

Consider an integer array arr of length n. 
Find the number of distinct special integers in the arr. 

An integer i is called a special integer if all of i-1, i, and i+1 are present in the arr.

Example 1:
Input:
n = 5
arr = {1, 2, 3, 3, 4}
Output: 2
Explanation:
The special integers in this arr are 2 and 3.

Example 2:
Input:
n = 4
arr = {2, 3, 5, 7}
Output: 0
Explanation:
There is no special integer in this arr.

Your Task:
You have to complete the function specialIntegers() 
which takes integer n and an array arr of length n as input, 
and returns the number of distinct special integers in the arr.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
*/

import java.util.*;

class Solution {
    public static int specialIntegers(int n, int[] arr) {
        // Store all elements for O(1) lookups
        Set<Integer> elements = new HashSet<>();
        for (int num : arr) {
            elements.add(num);
        }

        // Store distinct special integers
        Set<Integer> specialSet = new HashSet<>();
        for (int num : arr) {
            if (elements.contains(num - 1) && elements.contains(num) && elements.contains(num + 1)) {
                specialSet.add(num);
            }
        }

        return specialSet.size();
    }
}

/*
Time Complexity: O(n)
- O(n) to insert elements into the HashSet
- O(n) to iterate and check conditions

Space Complexity: O(n)
- O(n) for the HashSet storing all elements
- O(n) for the HashSet storing special integers
*/
