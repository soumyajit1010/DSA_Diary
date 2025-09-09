package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.One_Extra_Character;/*
One Extra Character
Difficulty: Easy

Given two strings s1 and s2 that contain same characters albeit arranged in different permutations. 
Now, an extra character can exist in either of s1 or s2. You need to find this extra character.

Example 1:
Input: s1 = "abba", s2 = "baxab"
Output: x

Example 2:
Input: s1 = "geeks", s2 = "segkep"
Output: p

Explanation:
In both cases, one of the strings has all the characters of the other plus one extra character.
*/

// User function Template for Java
class Solution {
    public static Character oneExtraCharacter(String s1, String s2) {
        int res = 0;

        // XOR all characters of s1
        for (char c : s1.toCharArray()) {
            res ^= c;
        }

        // XOR all characters of s2
        for (char c : s2.toCharArray()) {
            res ^= c;
        }

        return (char) res;
    }
}

/*
public static Character oneExtraCharacter(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of characters in s1
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Subtract frequency for characters in s2
        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        // Find character with frequency ±1 (extra character)
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }

        return null; // fallback (ideally should never reach here)
    }
 */