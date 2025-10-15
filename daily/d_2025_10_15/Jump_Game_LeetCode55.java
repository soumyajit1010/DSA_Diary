package DSA_Diary.daily.d_2025_10_15;
/*
💡 Problem: 55. Jump Game

📝 Problem Statement:
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

🔹 Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

🔹 Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what.
Its maximum jump length is 0, which makes it impossible to reach the last index.

------------------------------------------------------------

✅ Approach: Greedy Algorithm
We maintain the farthest index reachable (`reachable`) at each step.
If at any point the current index `i` is greater than `reachable`,
it means we cannot move forward — hence return false.
Otherwise, keep updating `reachable = max(reachable, i + nums[i])`.

If we reach the end of the loop, it means we can reach the last index.

------------------------------------------------------------

⏱ Time Complexity: O(n)
👉 We iterate through the array once.

💾 Space Complexity: O(1)
👉 Only a few integer variables are used.

*/
public class Jump_Game_LeetCode55 {
    public boolean canJump(int[] nums) {

        int reachable = 0; // farthest index we can reach

        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false; // can't move further
            reachable = Math.max(reachable, i + nums[i]); // update farthest reachable index
        }

        return true; // successfully reached or passed the last index
    }
}
