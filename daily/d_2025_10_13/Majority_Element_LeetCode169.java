package DSA_Diary.daily.d_2025_10_13;

import java.util.Hashtable;
/*
169. Majority Element
Easy

Problem Statement:
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Approach (HashMap):
1. Use a HashMap to count the frequency of each element.
2. While counting, check if the frequency exceeds n/2, if yes return the element.
3. Time Complexity: O(n) — we iterate through the array once.
4. Space Complexity: O(n) — HashMap stores counts of elements.

Approach (Boyer-Moore Voting Algorithm):
1. Initialize a candidate element and a count variable.
2. Traverse the array:
   - If count == 0, set current element as candidate.
   - If element == candidate, increment count.
   - Else, decrement count.
3. Return the candidate at the end.
4. Time Complexity: O(n) — single pass through the array.
5. Space Complexity: O(1) — constant extra space.
*/

public class Majority_Element_LeetCode169 {
    public int majorityElement(int[] nums) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            table.put(num, table.getOrDefault(num, 0) + 1);
            if (table.get(num) > n / 2) {
                return num; // Early return if majority found
            }
        }
        return -1;
/*
Time Complexity: O(n)
Space Complexity: O(1)
 */
    }

    // Boyer-Moore Voting Algorithm
    public int majorityElementBoyerMoore(int[] nums) {
        int candidate = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
    /*
Time Complexity: O(n)
Space Complexity: O(1)
 */
}
