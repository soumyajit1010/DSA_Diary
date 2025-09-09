package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Closest_Strings;/*
🧩 Problem: Closest Strings
---------------------------
Given a list of words `s` and two words `word1` and `word2`, find the **minimum distance** between the indices of these two words.

Note:
- `word1` and `word2` are guaranteed to be in the list.
- There can be multiple occurrences of either word.
Note:
- word1 and word2 may be the same.
- There can be multiple occurrences.

🧪 Examples:

Input:
S = {"the", "quick", "brown", "fox", "quick"}
word1 = "the"
word2 = "fox"
Output: 3

Input:
S = {"geeks", "for", "geeks", "contribute", "practice"}
word1 = "geeks"
word2 = "practice"
Output: 2

Input:
S = {"qz", "jm", "dv", "ejs", "of", "ejs", "qz"}
word1 = "qz", word2 = "qz"
Output: 0
*/

import java.util.*;

class Solution {
    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int index1 = -1, index2 = -1;
        int minDistance = Integer.MAX_VALUE;

        if (word1.equals(word2)) {
            // GFG wants 0 if both words are same — even if at different positions
            return 0;
        } else {
            for (int i = 0; i < s.size(); i++) {
                if (s.get(i).equals(word1)) {
                    index1 = i;
                } else if (s.get(i).equals(word2)) {
                    index2 = i;
                }

                if (index1 != -1 && index2 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                }
            }
        }

        return minDistance;
    }
};

/*
🕒 Time Complexity: O(n)
   - Traverse the list once

🧠 Space Complexity: O(1)
   - No extra space except a few variables
*/
