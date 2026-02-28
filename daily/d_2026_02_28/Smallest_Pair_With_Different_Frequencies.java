package DSA_Diary.daily.d_2026_02_28;

import java.util.*;
/*
Q1. Smallest Pair With Different Frequencies

You are given an integer array nums.

Consider all pairs of distinct values x and y from nums such that:
1. x < y
2. x and y have different frequencies in nums.

Among all such pairs:
- Choose the pair with the smallest possible value of x.
- If multiple pairs have the same x, choose the one with the smallest possible value of y.

Return an integer array [x, y].
If no valid pair exists, return [-1, -1].

-----------------------------------------------------

Example 1:
Input: nums = [1,1,2,2,3,4]
Output: [1,3]

Example 2:
Input: nums = [1,5]
Output: [-1,-1]

Example 3:
Input: nums = [7]
Output: [-1,-1]

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
*/

class Smallest_Pair_With_Different_Frequencies {
    public int[] minDistinctFreqPair(int[] nums) {
        int n = nums.length;
        if (n < 2) return new int[]{-1, -1};

        // Step 1: Count frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store distinct elements and sort them
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        // Step 3: Check all valid pairs
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int y = list.get(j);

                if (!map.get(x).equals(map.get(y))) {
                    return new int[]{x, y};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
