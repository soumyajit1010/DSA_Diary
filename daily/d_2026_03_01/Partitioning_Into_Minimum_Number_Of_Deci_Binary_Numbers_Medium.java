package DSA_Diary.daily.d_2026_03_01;



/*
===============================================================
1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
Medium

A decimal number is called deci-binary if each of its digits is
either 0 or 1 without any leading zeros.

Examples:
- 101 and 1100 are deci-binary.
- 112 and 3001 are NOT deci-binary.

Given a string n that represents a positive decimal integer,
return the minimum number of positive deci-binary numbers needed
so that they sum up to n.

---------------------------------------------------------------

Example 1:
Input:  n = "32"
Output: 3
Explanation: 10 + 11 + 11 = 32

Example 2:
Input:  n = "82734"
Output: 8

Example 3:
Input:  n = "27346209830709182346"
Output: 9

---------------------------------------------------------------

Constraints:
1 <= n.length <= 10^5
n consists of only digits.
n has no leading zeros.
===============================================================
*/

public class Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers_Medium {
    public int minPartitions(String n) {

        /*
        -----------------------------------------------------------
        KEY OBSERVATION:
        Each deci-binary number contributes at most 1 to each digit
        position (since digits can only be 0 or 1).

        Therefore:
        To build a digit 'd', we need at least 'd' deci-binary numbers.

        So the answer = maximum digit present in the string.
        -----------------------------------------------------------
        */

        int maxDigit = 0;

        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
        }

        return maxDigit;
    }
}