package DSA_Diary.daily.d_2025_10_11.LeetCode_Biweekly_Contest_167;

public class Q1 {
}

/*
3707. Equal Score Substrings
Easy

You are given a string s consisting of lowercase English letters.

The score of a string is the sum of the positions of its characters in the alphabet,
where 'a' = 1, 'b' = 2, ..., 'z' = 26.

Determine whether there exists an index i such that the string can be split into two
non-empty substrings s[0..i] and s[(i + 1)..(n - 1)] that have equal scores.

Return true if such a split exists, otherwise return false.

Example 1:
Input: s = "adcb"
Output: true
Explanation: Split at index i = 1:
Left substring = "ad" (1+4=5)
Right substring = "cb" (3+2=5)

Example 2:
Input: s = "bace"
Output: false
Explanation: No split produces equal scores.
*/

class Solution {
    public boolean scoreBalance(String s) {
        // Loop through all possible split points (from index 1 to length-1)
        for (int i = 1; i < s.length(); i++) {
            // Split string into two substrings
            String first = s.substring(0, i);
            String second = s.substring(i);

            // Calculate score for both substrings
            int f = function(first);
            int ss = function(second);

            // If scores are equal, return true
            if (f == ss) {
                return true;
            }
        }

        // If no split produces equal scores, return false
        return false;
    }

    // Helper function to calculate the score of a string
    public int function(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // 'a' = 1, 'b' = 2, ..., 'z' = 26
            res += (s.charAt(i) - 'a' + 1);
        }
        return res;
    }
}
//tc O(n^2)
//sc O(n)


/*
3707. Equal Score Substrings
Optimized O(n) version using running prefix sum
*/

class Solution2 {
    public boolean scoreBalance(String s) {
        int n = s.length();
        int total = 0;

        // Step 1: Calculate total score of the string
        for (int i = 0; i < n; i++) {
            total += (s.charAt(i) - 'a' + 1);
        }

        // Step 2: Traverse and maintain running sum
        int prefixSum = 0;
        for (int i = 0; i < n - 1; i++) { // split must be non-empty
            prefixSum += (s.charAt(i) - 'a' + 1);

            // Step 3: Check if current prefix sum equals remaining sum
            if (prefixSum == total - prefixSum) {
                return true;
            }
        }

        // Step 4: No split found
        return false;
    }
}
//TC O(n)
//SC O(1)