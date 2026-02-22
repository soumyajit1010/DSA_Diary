package DSA_Diary.daily.d_2026_02_22;

/*
Q1. Find the Score Difference in a Game
Difficulty: Medium

You are given an integer array nums, where nums[i]
represents the points scored in the ith game.

There are exactly two players.

Initially:
- First player is active
- Second player is inactive

Rules applied sequentially for each game i:

1. If nums[i] is odd → swap active and inactive players.
2. In every 6th game (i = 5, 11, 17, ...) → swap players.
3. The active player gains nums[i] points.

Return:
First player's total score − Second player's total score.

---------------------------------------------------------

Example 1:
Input: nums = [1,2,3]
Output: 0

Example 2:
Input: nums = [2,4,2,1,2,1]
Output: 4

Example 3:
Input: nums = [1]
Output: -1
---------------------------------------------------------
*/

class Solution {

    public int scoreDifference(int[] nums) {

        // true → first player active
        // false → second player active
        boolean firstActive = true;

        int firstScore = 0;
        int secondScore = 0;

        for (int i = 0; i < nums.length; i++) {

            // Rule 1: If score is odd → swap players
            if (nums[i] % 2 != 0) {
                firstActive = !firstActive;
            }

            // Rule 2: Every 6th game (index 5, 11, 17, ...)
            if ((i + 1) % 6 == 0) {
                firstActive = !firstActive;
            }

            // Active player gets points
            if (firstActive) {
                firstScore += nums[i];
            } else {
                secondScore += nums[i];
            }
        }

        // Return score difference
        return firstScore - secondScore;
    }

    /*
    Time Complexity: O(n)
    - Single traversal of array.

    Space Complexity: O(1)
    - Only constant extra variables used.
    */
}