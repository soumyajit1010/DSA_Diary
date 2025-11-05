/*
875. Koko Eating Bananas
Medium

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
*/

package DSA_Diary.daily.d_2025_11_05;

public class Koko_Eating_Bananas_LeetCode_875 {

    // Function to find the maximum number in the array
    public int findMax(int[] piles) {
        int maxi = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxi = Math.max(maxi, pile);
        }
        return maxi;
    }

    // Function to calculate total hours needed for a given eating speed
    public int calculateTotalHours(int[] piles, int speed) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += Math.ceil((double) pile / speed);
        }
        return totalHours;
    }

    // Main function to find the minimum eating speed
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalH = calculateTotalHours(piles, mid);

            if (totalH <= h) {
                ans = mid;       // possible answer, try to minimize
                high = mid - 1;
            } else {
                low = mid + 1;   // too slow, increase speed
            }
        }
        return ans;
    }
}

/*
Time Complexity:
O(n * log(max(piles)))
→ n = number of piles
→ log(max(piles)) comes from binary search range (1 to max pile value)

Space Complexity: O(1)
*/
