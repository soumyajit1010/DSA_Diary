package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Get_smaller_elements;// Question:
// Get smaller elements
// Difficulty: Easy
// Given an array arr[]. Return all the elements which are less than the given element `target`.
// Return an ArrayList containing all smaller elements in order of their occurrence.
//
// Example 1:
// Input: arr[] = [54, 43, 2, 1, 5], target = 7
// Output: [2, 1, 5]
//
// Example 2:
// Input: arr[] = [324, 5, 2, 2], target = 3
// Output: [2, 2]

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> getSmaller(int arr[], int target) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (num < target) {
                result.add(num);
            }
        }
        return result;
    }
}



/*
 * 💬 Problem: Get Smaller Elements
 *
 * Given an array arr, return all elements which are less than the given target.
 * Return the result as an ArrayList in the order of their occurrence.
 *
 * Examples:
 * Input: arr[] = [54, 43, 2, 1, 5], target = 7
 * Output: [2, 1, 5]
 * Explanation: 2, 1, and 5 are smaller than 7.
 *
 * Input: arr[] = [324, 5, 2, 2], target = 3
 * Output: [2, 2]
 * Explanation: 2 and 2 are smaller than 3.
 */


/*
class Solution {
    public static ArrayList<Integer> getSmaller(int arr[], int target) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (num < target) {
                result.add(num);
            }
        }

        return result;
    }
}
 */

/*
 * ✅ Time Complexity: O(n)
 * ✅ Space Complexity: O(n)
 *    - O(n) in worst case when all elements are smaller than target
 * where n = number of elements in the array
 */
