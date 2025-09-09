package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Smallest_Positive_Missing_Number;/*
Smallest Positive Missing Number
Difficulty: Easy  Accuracy: 58.96%  Submissions: 538+  Points: 2

You are given a list 'numbers', you need to find the smallest positive missing number.

Example 1:
Input: numbers = [1, 2, 3, 4]
Output: 5
Explanation: 5 is the smallest positive missing number.

Example 2:
Input: numbers = [6, 5, 3, 1]
Output: 2
Explanation: 2 is the smallest positive missing number.

Your Task:
Complete the function missingPositiveNumber that takes 'numbers' as argument
and returns the smallest positive missing number.
*/

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    // Complete this function
    // 'numbers' is the list argument
    // Return the smallest positive missing number
    static int missingPositiveNumber(ArrayList<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (num > 0) set.add(num); // only consider positive numbers
        }

        int smallest = 1;
        while (set.contains(smallest)) {
            smallest++;
        }

        return smallest;
    }
}
