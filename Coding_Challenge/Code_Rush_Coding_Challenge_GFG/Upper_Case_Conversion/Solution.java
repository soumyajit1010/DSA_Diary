package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Upper_Case_Conversion;/*
Upper Case Conversion
Difficulty: Basic  | Accuracy: 38.13%

Given a string s, convert the first letter of each word in the string to uppercase.

Examples:

Input: s = "gEEKs"
Output: "GEEKs"

Input: s = "i love programming"
Output: "I Love Programming"
*/

// User function Template for Java

class Solution {
    public String convert(String s) {
        // Split the input string into words
        String[] words = s.split(" ");
        
        // Use StringBuilder for efficient string manipulation
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (!word.isEmpty()) {
                // Capitalize first character and keep rest as-is
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1));
                }
                result.append(" ");
            }
        }
        
        // Remove the trailing space and return the result
        return result.toString().trim();
    }
}
