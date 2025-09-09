package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Outermost_Parentheses;/*
    Outermost Parentheses
    Difficulty: Easy
    Accuracy: 61.96%
    Submissions: 10K+
    Points: 2
    Average Time: 10m

    Problem:
    A valid parentheses string is either:
        "" (empty)
        "(" + X + ")"  where X is valid
        X + Y where X and Y are valid
    + represents string concatenation.

    A primitive valid parentheses string is a valid parentheses string that cannot be split
    into two non-empty valid parentheses strings.

    Given a valid parentheses string s:
    - Decompose it into primitive parts P1 + P2 + ... + Pk.
    - Remove the outermost parentheses of each primitive part.
    - Return the result.

    Example 1:
    Input: s = "(()())(())"
    Output: "()()()"
    Explanation: "(()())" -> "()()", "(())" -> "()"

    Example 2:
    Input: s = "()()"
    Output: ""
    Explanation: "()" -> "", "()" -> ""

    Expected Time Complexity: O(n)
    Expected Space Complexity: O(n)
*/

class Solution {
    public static String removeOuter(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (depth > 0) { 
                    // Skip adding if this '(' is the outermost
                    result.append(ch);
                }
                depth++;
            } else if (ch == ')') {
                depth--;
                if (depth > 0) {
                    // Skip adding if this ')' is the outermost
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}

/*
    Time Complexity: O(n)
    - We iterate through the string once.

    Space Complexity: O(n)
    - We store the resulting string in a StringBuilder.
*/
