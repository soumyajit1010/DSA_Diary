/*
1482. Minimum Number of Days to Make m Bouquets
Medium

You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
If it is impossible to make m bouquets return -1.

Example 1:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation:
After day 1: [x, _, _, _, _]  → 1 bouquet
After day 2: [x, _, _, _, x]  → 2 bouquets
After day 3: [x, _, x, _, x]  → 3 bouquets → Answer = 3

Example 2:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation:
We need 3 bouquets each having 2 adjacent flowers (total 6 flowers), but we have only 5 → Impossible.

Example 3:
Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation:
After day 7 → [x,x,x,x,_,x,x] → 1 bouquet possible
After day 12 → [x,x,x,x,x,x,x] → 2 bouquets → Answer = 12
*/

package DSA_Diary.daily.d_2025_11_06;

public class Minimum_days_to_make_M_bouquets_LeetCode_1482 {

    // Helper function to check if it's possible to make 'm' bouquets in 'day' days
    public boolean possible(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) {  // one bouquet formed
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0; // reset if flower not bloomed
            }
        }
        return bouquets >= m;
    }

    // Main function to find the minimum days
    public int minDays(int[] bloomDay, int m, int k) {
        long total = (long) m * k;
        if (total > bloomDay.length) return -1; // not enough flowers

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            min = Math.min(min, bloom);
            max = Math.max(max, bloom);
        }

        int low = min, high = max, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1; // try smaller days
            } else {
                low = mid + 1; // need more days
            }
        }
        return ans;
    }
}

/*
Time Complexity:
O(n * log(max(bloomDay) - min(bloomDay)))
→ n = number of flowers
→ log(range of days) due to binary search on days

Space Complexity: O(1)
*/
