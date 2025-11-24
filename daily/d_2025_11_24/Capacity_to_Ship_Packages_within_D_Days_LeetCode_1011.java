package DSA_Diary.daily.d_2025_11_24;
/**
 * 1011. Capacity To Ship Packages Within D Days
 *
 * A conveyor belt has packages that must be shipped from one port to another within `days` days.
 *
 * The i-th package has a weight: weights[i].
 * Each day, you must load the ship with packages in the SAME ORDER they appear.
 * You cannot rearrange or split packages.
 *
 * The ship has a max weight capacity (you need to find this).
 * If adding a package exceeds the ship capacity, that package goes to the next day.
 *
 * Return the MINIMUM ship capacity needed to ship all packages within `days` days.
 *
 * Example 1:
 * Input:  weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * Output: 15
 *
 * Example 2:
 * Input:  weights = [3,2,2,4,1,4], days = 3
 * Output: 6
 *
 * Example 3:
 * Input:  weights = [1,2,3,1,1], days = 4
 * Output: 3
 *
 * Constraints:
 * 1 <= weights.length <= 5 * 10^4
 * 1 <= weights[i] <= 500
 * 1 <= days <= weights.length
 */
public class Capacity_to_Ship_Packages_within_D_Days_LeetCode_1011 {

    public int shipWithinDays(int[] weights, int days) {

        int maxele = 0;
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
            if (maxele < weight) maxele = weight;
        }
        int min = maxele;
        int max = sum;

        for (int i = min; i <= max; i++) {
            int daysReq = shipWithinDays(weights, i);
            if (daysReq <= days) return i;
        }
        return -1;
    }

    // helper: how many days needed if ship capacity is cap
    private int daysNeeded(int[] weights, int cap) {
        int days = 1;
        int load = 0;
        for (int w : weights) {
            if (load + w > cap) {
                days++;
                load = w;
            } else {
                load += w;
            }
        }
        return days;
    }

    public int shipWithinDays1(int[] weights, int days) {
        int maxEle = 0;
        long sum = 0;
        for (int w : weights) {
            maxEle = Math.max(maxEle, w);
            sum += w;
        }

        int low = maxEle;         // capacity cannot be less than the heaviest package
        int high = (int) sum;     // capacity need not be more than total sum
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int req = daysNeeded(weights, mid);

            if (req <= days) {    // can finish within 'days' with capacity mid
                ans = mid;        // mid is a candidate
                high = mid - 1;   // try smaller capacity
            } else {
                low = mid + 1;    // need bigger capacity
            }
        }

        return ans;
    }
}
