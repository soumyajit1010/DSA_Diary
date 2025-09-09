package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Wave_Array;/*
❓ QUESTION: Wave Array
Difficulty: Medium

Given a sorted array arr[] of integers, convert it into a wave-like array in-place.
Arrange the elements such that:
    arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] ... and so on.

⚠️ NOTE:
- The input array is already sorted in ascending order.
- Modify the array in-place, do not return a new one.
- If multiple answers are possible, return the lexicographically smallest one.

🧪 Examples:

Input: arr[] = [1, 2, 3, 4, 5]
Output: [2, 1, 4, 3, 5]

Input: arr[] = [2, 4, 7, 8, 9, 10]
Output: [4, 2, 8, 7, 10, 9]

Input: arr[] = [1]
Output: [1]
*/

class Solution {
    public void sortInWave(int arr[]) {
        // Loop through the array in steps of 2
        for (int i = 0; i < arr.length - 1; i += 2) {
            // Swap arr[i] and arr[i+1]
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
