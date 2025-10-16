package DSA_Diary.daily.d_2025_10_16;

/*
45. Jump Game II
----------------
You are given a 0-indexed array of integers nums of length n.
You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at index i, you can jump to any index (i + j) where:
0 <= j <= nums[i] and i + j < n.

Return the minimum number of jumps to reach index n - 1.
The test cases are generated such that you can reach index n - 1.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Jump_Game_II_LeetCode45 {
    public int jump(int[] nums) {
        int jumps = 0;       // number of jumps made so far
        int end = 0;         // end of the current jump range
        int farthest = 0;    // farthest we can reach in the next jump

        // We don’t need to jump from the last index
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // update the farthest reach

            // If we’ve reached the end of our current jump range
            if (i == end) {
                jumps++;        // make a jump
                end = farthest; // update the end of the new range
            }
        }

        return jumps;
    }
}
