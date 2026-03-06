package DSA_Diary.daily.d_2026_03_06;/*
LeetCode 1784. Check if Binary String Has at Most One Segment of Ones
Difficulty: Easy

Problem:
Given a binary string s without leading zeros, return true if the string
contains at most one contiguous segment of '1's. Otherwise return false.

A segment means consecutive '1's appearing together.

Example 1:
Input: s = "1001"
Output: false
Explanation:
The ones appear in two segments → "1" and "1".

Example 2:
Input: s = "110"
Output: true
Explanation:
The ones form only one contiguous segment → "11".

Example 3:
Input: s = "111000"
Output: true

Example 4:
Input: s = "101"
Output: false

Key Idea:
There should be at most one continuous block of '1's.
Once we encounter a '0' after '1', we should not see '1' again.
*/


// ------------------------------------------------------------
// Approach 1: Brute Force (Nested Loop)
// ------------------------------------------------------------
/*
Idea:
1. Find the first occurrence where '1' is followed by '0'.
2. Then check if any '1' appears later.
3. If yes → there are multiple segments of '1'.

Time Complexity: O(n²)
Space Complexity: O(1)
*/

class Check_if_Binary_String {
    public boolean checkOnesSegment(String s) {

        for (int i = 0; i < s.length() - 2; i++) {

            if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {

                for (int j = i + 2; j < s.length(); j++) {
                    if (s.charAt(j) == '1')
                        return false;
                }

            }
        }

        return true;
    }




// ------------------------------------------------------------
// Approach 2: Linear Scan (Optimal)
// ------------------------------------------------------------
/*
Idea:
If we ever see pattern:
0 → 1

That means a new segment of '1' started.

So if s[i-1] == '0' and s[i] == '1'
then return false.

Time Complexity: O(n)
Space Complexity: O(1)
*/

    public boolean checkOnesSegment22(String s) {

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0')
                return false;

        }

        return true;
    }




// ------------------------------------------------------------
// Approach 3: Using String Contains Trick
// ------------------------------------------------------------
/*
Observation:
If there are multiple segments of '1',
the string must contain "01" followed by another '1'.

But simpler rule:
If substring "01" exists, then a new '1' cannot appear later.

However because string has no leading zeros,
checking "01" alone works.

Time Complexity: O(n)
Space Complexity: O(1)
*/

    public boolean checkOnesSegment33(String s) {
        return !s.contains("01");
    }
}