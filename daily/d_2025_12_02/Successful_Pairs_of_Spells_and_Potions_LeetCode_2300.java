package DSA_Diary.daily.d_2025_12_02;

import java.util.Arrays;

public class Successful_Pairs_of_Spells_and_Potions_LeetCode_2300 {

    /*
     ==========================================================
     🔥 2300. Successful Pairs of Spells and Potions — LeetCode
     ==========================================================

     You are given:
       • spells[]  → strength of spells  (size n)
       • potions[] → strength of potions (size m)
       • success   → minimum required product

     A spell–potion pair is "successful" if:
            spells[i] * potions[j] ≥ success

     Return an array result[], where:
            result[i] = number of potions that form a successful pair
                         with spell spells[i].

     ----------------------------------------------------------
     Example 1:
     Input:
        spells  = [5,1,3]
        potions = [1,2,3,4,5]
        success = 7
     Output:
        [4, 0, 3]

     ----------------------------------------------------------
     Example 2:
     Input:
        spells = [3,1,2]
        potions = [8,5,8]
        success = 16
     Output:
        [2, 0, 2]
     ----------------------------------------------------------

     ==========================================================
     🔵 Approach 1: Brute Force (Check all pairs)
     ==========================================================
     For each spell:
        For each potion:
            check if spell * potion ≥ success

     Time Complexity:
            O(n * m)
     Space Complexity:
            O(1)

     Very slow for large inputs (n, m ≤ 10^5).

     ==========================================================
     🔵 Approach 2: Optimal — Sorting + Binary Search
     ==========================================================
     Key idea:
       For each spell:
          - Find minimum potion strength needed:
                required = ceil(success / spell)
                       = (success + spell - 1) / spell

          - Binary search in sorted potions[] to find the
            FIRST index where potions[index] ≥ required

          - All later potions will also work.

     Number of successful potions for this spell:
            m - index

     Time Complexity:
            Sorting:   O(m log m)
            For each spell:
                Binary Search: O(log m)
            Total: O(m log m + n log m)

     Space Complexity:
            O(1) (ignoring output array)

     Much faster and optimal.
     ==========================================================
     */


    // ---------------------------------------------------------
    // 🔵 Brute Force Approach — O(n*m)
    // ---------------------------------------------------------
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int count = 0;

            for (int j = 0; j < potions.length; j++) {
                long product = (long) spells[i] * potions[j];

                if (product >= success) {
                    count++;
                }
            }

            res[i] = count;
        }

        return res;
    }


    // ---------------------------------------------------------
    // 🔵 Optimal Approach — Sorting + Binary Search
    // ---------------------------------------------------------
    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            long spell = spells[i];

            // Minimum potion strength needed (ceil division)
            long required = (success + spell - 1) / spell;

            int low = 0, high = m - 1;
            int firstValidIndex = m;

            // Binary search for first potion ≥ required
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (potions[mid] >= required) {
                    firstValidIndex = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // All potions from firstValidIndex to end are successful
            res[i] = m - firstValidIndex;
        }

        return res;
    }

}
