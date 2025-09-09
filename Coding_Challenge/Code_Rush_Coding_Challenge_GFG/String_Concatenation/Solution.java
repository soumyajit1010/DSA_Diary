package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.String_Concatenation;// String Concatenation
// Difficulty: Basic   Accuracy: 90.16%   Submissions: 2K+   Points: 1

// Given an ArrayList `arr` of strings. The ArrayList will contain `n` strings.
// You need to concatenate them so that a concatenated string gets printed.

// Example 1:
// Input:
// 5
// geeks for geeks and good
// Output:
// geeksforgeeksandgood
// Explanation:
// We have just concatenated the strings.

// Example 2:
// Input:
// 4
// the quick brown fox
// Output:
// thequickbrownfox
// Explanation:
// We have just concatenated the strings.

// User Task:
// You need to complete the function `concatenateString` that takes `arr` as an argument.
// The function should return a string that contains the concatenation of strings from `arr`.
// The driver code prints the returned value.

import java.util.*;

class Solution {
    public static String concatenateString(ArrayList<String> arr) {
        // Using StringBuilder for efficient concatenation
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }

    // For testing purposes
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("the", "quick", "brown", "fox"));
        System.out.println(concatenateString(arr)); // Output: thequickbrownfox
    }
}
