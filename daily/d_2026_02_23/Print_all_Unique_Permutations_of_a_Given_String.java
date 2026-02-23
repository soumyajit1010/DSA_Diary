package DSA_Diary.daily.d_2026_02_23;/*
Print all Unique Permutations of a Given String
Difficulty: Medium

Given a string that may contain duplicate characters,
print all UNIQUE permutations in any order.

------------------------------------------------------------

Example 1:
Input: "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]

Example 2:
Input: "AAA"
Output: ["AAA"]

------------------------------------------------------------
*/

/* =========================================================
   APPROACH 1: Naive Approach (Generate All + HashSet)
   =========================================================
   Idea:
   - Generate all permutations (including duplicates)
   - Store them in a HashSet to remove duplicates
   - Convert set to list

   Time Complexity: O(n * n!)
   Space Complexity: O(n!)  (HashSet stores permutations)
*/

import java.util.*;

class Print_all_Unique_Permutations_of_a_Given_String
{

    // ---------- NAIVE METHOD ----------
    static void generateAll(int index, String s,
                            boolean[] used,
                            StringBuilder curr,
                            HashSet<String> set) {

        if (curr.length() == s.length()) {
            set.add(curr.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                curr.append(s.charAt(i));

                generateAll(index + 1, s, used, curr, set);

                // Backtrack
                curr.deleteCharAt(curr.length() - 1);
                used[i] = false;
            }
        }
    }

    static ArrayList<String> findPermutation_Naive(String s) {

        HashSet<String> set = new HashSet<>();
        boolean[] used = new boolean[s.length()];
        StringBuilder curr = new StringBuilder();

        generateAll(0, s, used, curr, set);

        return new ArrayList<>(set);
    }


    /* =========================================================
       APPROACH 2: Expected Approach (Generate Only Unique)
       =========================================================
       Idea:
       - Use frequency map of characters
       - At each recursion level, choose only characters
         whose count > 0
       - This avoids duplicate permutations

       Time Complexity: O(n * n!)
       Space Complexity: O(n) (recursion stack + frequency map)
    */

    static void generateUnique(int n,
                               StringBuilder curr,
                               Map<Character, Integer> freq,
                               ArrayList<String> result) {

        if (curr.length() == n) {
            result.add(curr.toString());
            return;
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {

            char ch = entry.getKey();
            int count = entry.getValue();

            if (count == 0)
                continue;

            // Choose character
            curr.append(ch);
            freq.put(ch, count - 1);

            generateUnique(n, curr, freq, result);

            // Backtrack
            curr.deleteCharAt(curr.length() - 1);
            freq.put(ch, count);
        }
    }

    static ArrayList<String> findPermutation(String s) {

        ArrayList<String> result = new ArrayList<>();
        Map<Character, Integer> freq = new HashMap<>();

        // Build frequency map
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        generateUnique(s.length(), new StringBuilder(), freq, result);

        return result;
    }


    // --------- DRIVER ----------
    public static void main(String[] args) {

        String s = "ABC";

        System.out.println("Naive Approach:");
        ArrayList<String> res1 = findPermutation_Naive(s);
        for (String str : res1)
            System.out.print(str + " ");

        System.out.println("\n\nOptimized Approach:");
        ArrayList<String> res2 = findPermutation(s);
        for (String str : res2)
            System.out.print(str + " ");
    }
}