package DSA_Diary.daily.d_2026_02_08;

public class Count_Subarrays {


     /*
    3835. Count Subarrays With Cost Less Than or Equal to K (Medium)

    You are given an integer array nums and an integer k.

    For any subarray nums[l..r], define its cost as:
        cost = (max(nums[l..r]) - min(nums[l..r])) * (r - l + 1)

    Task:
    Return the number of subarrays whose cost is less than or equal to k.

    -------------------------------------------------
    Example 1:
    Input: nums = [1,3,2], k = 4
    Output: 5

    Explanation:
    nums[0..0] → (1-1)*1 = 0
    nums[0..1] → (3-1)*2 = 4
    nums[1..1] → (3-3)*1 = 0
    nums[1..2] → (3-2)*2 = 2
    nums[2..2] → (2-2)*1 = 0

    -------------------------------------------------
    Example 2:
    Input: nums = [5,5,5,5], k = 0
    Output: 10

    Explanation:
    All subarrays have max = min, so cost = 0.

    -------------------------------------------------
    Example 3:
    Input: nums = [1,2,3], k = 0
    Output: 3

    Explanation:
    Only single-element subarrays have cost = 0.
    */

    // -------------------------------------------------
    // Brute Force Solution
    // -------------------------------------------------
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0;

        // Fix starting index
        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int min = nums[i];

            // Extend subarray ending at j
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);

                long cost = (long) (max - min) * (j - i + 1);
                if (cost <= k) {
                    count++;
                }
            }
        }
        return count;
    }

    /*
    Time Complexity:
    O(n²)
    - Two nested loops over the array.

    Space Complexity:
    O(1)
    - Only constant extra variables used.
    */

}
