package DSA_Diary.daily.d_2026_03_05;

/*
LeetCode 1758. Minimum Changes To Make Alternating Binary String
Difficulty: Easy

Problem:
You are given a binary string s consisting only of '0' and '1'.

In one operation you can change:
'0' → '1'
or
'1' → '0'.

A string is called alternating if no two adjacent characters are equal.

Return the minimum number of operations needed to make the string alternating.

Example 1:
Input: s = "0100"
Output: 1
Explanation:
Change last character → "0101"

Example 2:
Input: s = "10"
Output: 0

Example 3:
Input: s = "1111"
Output: 2
Explanation:
Possible alternating strings:
"0101" or "1010"
*/
public class Minimum_Changes_To_Make_Alternating_Binary_String {
    public int minOperations(String s) {

        int n = s.length();

        int n1 = n;
        StringBuilder sb1 = new StringBuilder();
        boolean b = true;

        while (n1 > 0) {
            if (b) {
                sb1.append("0");
            } else {
                sb1.append("1");
            }
            b = !b;
            n1--;
        }

        int n2 = n;
        StringBuilder sb2 = new StringBuilder();
        boolean c = false;

        while (n2 > 0) {
            if (c) {
                sb2.append("0");
            } else {
                sb2.append("1");
            }
            c = !c;
            n2--;
        }

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != sb1.charAt(i)) c1++;
            if (s.charAt(i) != sb2.charAt(i)) c2++;
        }

        return Math.min(c1, c2);

    }




/*

Approach:
There are only two possible alternating strings:
1. Start with '0' → "010101..."
2. Start with '1' → "101010..."

Steps:
1. Construct both patterns.
2. Count mismatches with original string.
3. Return the minimum mismatch.

Time Complexity: O(n)
Space Complexity: O(n)
*/

    public int minOperations22(String s) {

        int n = s.length();

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        boolean startZero = true;
        boolean startOne = false;

        for (int i = 0; i < n; i++) {

            sb1.append(startZero ? '0' : '1');
            startZero = !startZero;

            sb2.append(startOne ? '0' : '1');
            startOne = !startOne;
        }

        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != sb1.charAt(i)) c1++;
            if (s.charAt(i) != sb2.charAt(i)) c2++;
        }

        return Math.min(c1, c2);
    }







    /*
Optimized Approach

Instead of building strings,
we check expected characters using index.

Pattern 1: 010101...
Pattern 2: 101010...

Time Complexity: O(n)
Space Complexity: O(1)
*/

    public int minOperations33(String s) {

        int countStart0 = 0;
        int countStart1 = 0;

        for (int i = 0; i < s.length(); i++) {

            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected0)
                countStart0++;

            if (s.charAt(i) != expected1)
                countStart1++;
        }

        return Math.min(countStart0, countStart1);
    }

}