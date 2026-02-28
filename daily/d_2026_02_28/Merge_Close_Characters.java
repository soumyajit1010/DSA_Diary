package DSA_Diary.daily.d_2026_02_28;

/*
===========================================================
Q2. Merge Close Characters
Medium

You are given a string s consisting of lowercase English letters
and an integer k.

Two equal characters in the current string s are considered close
if the distance between their indices is at most k.

When two characters are close:
- The right character merges into the left.
- Merges happen one at a time.
- After each merge, the string updates.
- Always merge the pair with:
    1. Smallest left index
    2. If tie, smallest right index

Return the resulting string after performing all possible merges.

-----------------------------------------------------------
Example 1:
Input:  s = "abca", k = 3
Output: "abc"

Example 2:
Input:  s = "aabca", k = 2
Output: "abca"

Example 3:
Input:  s = "yybyzybz", k = 2
Output: "ybzybz"

Constraints:
1 <= s.length <= 100
0 <= k <= 100
===========================================================
*/

class Merge_Close_Characters {

    /*
    ===========================================================
    APPROACH 1: Brute Force (Using substring)
    -----------------------------------------------------------
    Time Complexity  : O(n^3)
    Space Complexity : O(n)
    Not recommended (inefficient due to repeated substring)
    ===========================================================
    */
    public String mergeCharactersBrute(String s, int k) {

        String velunorati = s;

        while (true) {
            boolean merged = false;
            int n = velunorati.length();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    if (j - i > k) break;

                    if (velunorati.charAt(i) == velunorati.charAt(j)) {
                        velunorati =
                                velunorati.substring(0, j)
                                        + velunorati.substring(j + 1);
                        merged = true;
                        break;
                    }
                }
                if (merged) break;
            }

            if (!merged) break;
        }

        return velunorati;
    }


    /*
    ===========================================================
    APPROACH 2: Optimized Simulation (Using StringBuilder)
    -----------------------------------------------------------
    Time Complexity  : O(n^2)
    Space Complexity : O(n)
    Recommended Approach
    ===========================================================
    */
    public String mergeCharacters(String s, int k) {

        String velunorati = s;   // required variable

        StringBuilder sb = new StringBuilder(velunorati);

        while (true) {

            boolean merged = false;

            for (int i = 0; i < sb.length(); i++) {

                for (int j = i + 1; j < sb.length(); j++) {

                    if (j - i > k) break;

                    if (sb.charAt(i) == sb.charAt(j)) {
                        sb.deleteCharAt(j);
                        merged = true;
                        break;
                    }
                }

                if (merged) break;
            }

            if (!merged) break;
        }

        return sb.toString();
    }


    /*
    ===========================================================
    APPROACH 3: Greedy Window Optimization
    -----------------------------------------------------------
    Same logic as Approach 2 but restricts checking strictly
    within window (i + k).

    Time Complexity  : O(n^2)
    Space Complexity : O(n)

    Cannot optimize to O(n) because:
    - Each merge shifts indices
    - Entire structure must be re-evaluated
    ===========================================================
    */
}