package DSA_Diary.daily.d_2025_12_02;

/*
====================================================================================
   ❓ LeetCode 374 — Guess Number Higher or Lower
   -------------------------------------------------------------------------------
   We are playing a Guess Game.

   • I pick a number from 1 to n (call this number "pick")
   • You have to guess which number I picked.
   • You do NOT know the number.
   • LeetCode internally gives you hints using the API:

        int guess(int num)

        guess(num) returns:
            -1  → your guess is higher than the picked number
             1  → your guess is lower than the picked number
             0  → num == pick (correct guess)

   🔹 Your task: Return the number that I picked.

   -------------------------------------------------------------------------------
   📘 Example 1:
       Input: n = 10, pick = 6
       Output: 6

   📘 Example 2:
       Input: n = 1, pick = 1
       Output: 1

   📘 Example 3:
       Input: n = 2, pick = 1
       Output: 1

   -------------------------------------------------------------------------------
   💡 Idea:
       Since guess(num) tells us whether the guess is too high or too low,
       we can use Binary Search on the range [1, n].

   -------------------------------------------------------------------------------
   ⏳ Time Complexity:  O(log n)
   🧠 Space Complexity: O(1)
====================================================================================
*/


// This class extends GuessGame in LeetCode environment
/*
public class Guess_Number_Higher_or_Lower_Leetcode_374 extends GuessGame {

    public int guessNumber(int n) {

        int low = 1;
        int high = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int res = guess(mid);   // API call

            if (res == 0) {
                return mid;         // Found the picked number
            }
            else if (res == -1) {
                high = mid - 1;     // Mid is too high
            }
            else {
                low = mid + 1;      // Mid is too low
            }
        }

        return -1;  // Should never happen
    }
}
 */
