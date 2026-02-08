package DSA_Diary.daily.d_2026_02_08;
/*
3833. Count Dominant Indices (Easy)

You are given an integer array nums of length n.

An element at index i is called dominant if:
nums[i] > average(nums[i + 1], nums[i + 2], ..., nums[n - 1])

Note:
- The rightmost element is never dominant because there are no elements to its right.

Task:
Count the number of dominant indices.

Example 1:
Input: nums = [5,4,3]
Output: 2

Explanation:
i = 0 → 5 > average(4,3) = 3.5 ✓
i = 1 → 4 > average(3) = 3 ✓
i = 2 → not considered

Example 2:
Input: nums = [4,1,2]
Output: 1
*/

public class Count_Dominant_Indices {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Calculate total sum of array
        long suffixSum = 0;
        for (int num : nums) {
            suffixSum += num;
        }

        // Traverse till second last element
        for (int i = 0; i < n - 1; i++) {
            suffixSum -= nums[i]; // sum of elements to the right
            double avg = (double) suffixSum / (n - i - 1);

            if (nums[i] > avg) {
                count++;
            }
        }
        return count;
    }
}
