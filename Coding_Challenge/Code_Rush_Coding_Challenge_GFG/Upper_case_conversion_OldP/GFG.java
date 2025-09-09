package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Upper_case_conversion_OldP;/*
Upper case conversion OldP
Difficulty: School
Accuracy: 36.52%

Given a string, write a program to convert the first letter of every word to uppercase (Title Case).

Input:
The first line consists of an integer T (number of test cases).
The first and only line of each test case consists of a string s.

Output:
Print the required output for each test case.

Constraints:
1 <= T <= 100
1 <= |Length of string| <= 1000

Example:
Input:
1
I love programming
Output:
I Love Programming

Time Complexity:
- Splitting string into words: O(N)
- Building result: O(N)
Overall: O(N) where N is length of string.

Space Complexity: O(N) for output string (excluding input storage)
*/

import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine()); // read T

        while (T-- > 0) {
            String s = sc.nextLine();
            System.out.println(toTitleCase(s));
        }
        sc.close();
    }

    // Function to convert string to title case
    public static String toTitleCase(String str) {
        StringBuilder result = new StringBuilder(str.length());
        boolean capitalizeNext = true;

        for (char ch : str.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                result.append(ch);
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(ch));
                    capitalizeNext = false;
                } else {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}
