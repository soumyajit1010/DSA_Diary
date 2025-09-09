package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Are_Strings_Equal;/*
Are Strings Equal
Difficulty: Basic | Accuracy: 90.49%

Question:
Given two strings s1 and s2, find if they contain the same data or not.

Example 1:
Input:  s1 = "hello", s2 = "hello"
Output: true
Explanation: Both the strings have same data, so true is printed.

Example 2:
Input:  s1 = "geeks", s2 = "skeeg"
Output: false
Explanation: Both the strings are different, so print false.

User Task:
Complete the function areEqual that takes s1 and s2 as arguments and returns true 
if s1 and s2 contain the same data, else returns false.

Constraints:
1 <= s1.length(), s2.length() <= 1000
*/

/* ✅ Corrected and simplified function using String.equals() method */

class Solution {
    public static boolean areEqual(String s1, String s2) {
        // Compare both strings directly using .equals()
        return s1.equals(s2);
    }
}
