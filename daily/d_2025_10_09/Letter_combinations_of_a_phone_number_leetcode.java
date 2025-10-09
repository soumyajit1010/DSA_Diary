package DSA_Diary.daily.d_2025_10_09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17. Letter Combinations of a Phone Number
Difficulty: Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Constraints:
- 0 <= digits.length <= 4
- digits[i] is a digit in the range ['2', '9']
*/


public class Letter_combinations_of_a_phone_number_leetcode {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");


        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        f(map, digits, 0, "", res);

        return res;


    }

    public static void f(HashMap<Integer, String> map, String digits, int index, String current, List<String> res) {

        if (index == digits.length()) {
            res.add(current);
            return;
        }

        char digit = digits.charAt(index);
        int num = digit - '0';
        String str = map.get(num);

        // loop through each letter
        for (char ch : str.toCharArray()) {
            f(map, digits, index + 1, current + ch, res);
        }
    }
    /*
Time Complexity: O(n * k^n)
Space Complexity: O(n * k^n)
 */

// backtrack(map, digits, 0, new StringBuilder(), res);
    public static void backtrack2(Map<Integer, String> map, String digits, int index,
                                  StringBuilder current, List<String> res) {
        if(index == digits.length()) {
            res.add(current.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        String letters = map.get(num);

        for(char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack2(map, digits, index + 1, current, res);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
    /*
    Currently, every recursive call does current + ch, which creates a new
    string every time. Using StringBuilder avoids creating new strings repeatedly.
     */


    //Iterative Approach (BFS-like)
    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        // Mapping digits to letters
        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        res.add(""); // start with empty string

        for (char d : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            String letters = map[d - '0'];
            for (String comb : res) {
                for (char ch : letters.toCharArray()) {
                    temp.add(comb + ch);
                }
            }
            res = temp; // update the result list
        }
        return res;
    }
}
