package DSA_Diary.daily.d_2025_12_14;

import java.util.Arrays;

class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int smallSum = 0;
        int largeSum = 0;

        // Sum of k smallest elements
        for (int i = 0; i < k; i++) {
            smallSum += nums[i];
        }

        // Sum of k largest elements
        for (int i = n - k; i < n; i++) {
            largeSum += nums[i];
        }

        return Math.abs(largeSum - smallSum);
    }
}
