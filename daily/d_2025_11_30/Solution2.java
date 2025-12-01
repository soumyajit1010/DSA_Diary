package DSA_Diary.daily.d_2025_11_30;

import java.util.HashMap;

class Solution2 {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            int r = reverseNumber(nums[i]);
            for (int j = i + 1; j < n; j++) {
                if (r == nums[j]) {
                    res = Integer.min(res, j - i);
                }
            }
        }
        if (res > n) {
            return -1;
        } else {
            return res;
        }
    }

    public int minMirrorPairDistance2(int[] nums) {

        int[] ferilonsar = nums;  // as per question requirement

        int n = nums.length;
        int res = Integer.MAX_VALUE;

        // Map: value → latest index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int rev = reverseNumber(nums[i]);

            // If reversed number already appeared
            if (map.containsKey(rev)) {
                res = Math.min(res, i - map.get(rev));
            }

            // Store current number because some future reversed number may match it
            map.put(nums[i], i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int reverseNumber(int n) {
        int rev = 0;

        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }

        return rev;
    }


}