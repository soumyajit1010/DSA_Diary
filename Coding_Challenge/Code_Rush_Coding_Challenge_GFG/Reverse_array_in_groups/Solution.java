package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Reverse_array_in_groups;// 💡 Question:
// Reverse array in groups
// Difficulty: Medium
// Given an array arr[] of positive integers. Reverse every sub-array group of size k.
//
// Note: If at any instance, k is greater than or equal to the array size,
// then reverse the entire array.
//
// 🧪 Examples:
// Input: arr[] = [1, 2, 3, 4, 5], k = 3
// Output: [3, 2, 1, 5, 4]
//
// Input: arr[] = [5, 6, 8, 9], k = 5
// Output: [9, 8, 6, 5]

class Solution {
    public void reverseInGroups(int[] arr, int k) {
        int n = arr.length;

        // Traverse the array in chunks of size k
        for (int i = 0; i < n; i += k) {
            int left = i;
            // Calculate the right index (ensure it doesn't exceed array size)
            int right = Math.min(i + k - 1, n - 1);

            // Reverse the current group
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
