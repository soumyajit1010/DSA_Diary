package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Longest_Common_Prefix_of_Strings;/*
Question: Longest Common Prefix of Strings
Difficulty: Easy

Given an array of strings arr[]. Return the longest common prefix among each and every string present in the array.
If there's no prefix common in all the strings, return an empty string "".

Examples:

Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
Output: "gee"
Explanation: "gee" is the longest common prefix in all the given strings.

Input: arr[] = ["hello", "world"]
Output: ""
Explanation: There's no common prefix in the given strings.

Approach:
- Start with the first string.
- Compare each character position with all other strings.
- If any mismatch or string ends, return the prefix found so far.

Time Complexity: O(n * m)
    where n = number of strings,
          m = length of the shortest string
Space Complexity: O(1) (excluding the output string)
*/

class S {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) return "";

        int i = 0;

        while (true) {
            if (i >= arr[0].length()) break;

            char c = arr[0].charAt(i);

            for (int j = 1; j < arr.length; j++) {
                if (i >= arr[j].length() || arr[j].charAt(i) != c) {
                    return arr[0].substring(0, i);
                }
            }

            i++;
        }

        return arr[0].substring(0, i);
    }
}
