package DSA_Diary.daily.d_2026_03_08;/*
LeetCode 1980. Find Unique Binary String
Difficulty: Medium

Problem:
Given an array of strings nums containing n unique binary strings,
each of length n, return a binary string of length n that does NOT
appear in nums. If there are multiple answers, you may return any.

Example 1:
Input: nums = ["01","10"]
Output: "11"
Explanation: "11" is not present in nums. "00" would also work.

Example 2:
Input: nums = ["00","01"]
Output: "11"
Explanation: "11" is not present in nums. "10" would also work.

Example 3:
Input: nums = ["111","011","001"]
Output: "101"
Explanation: Any binary string of length 3 not in nums is valid.

Constraints:
1 <= nums.length <= 16
nums[i].length == nums.length
nums[i] consists of '0' and '1'.
All strings in nums are unique.
*/


// ------------------------------------------------------------
// Approach 1: Brute Force (Generate All Binary Strings)
// ------------------------------------------------------------
/*
Idea:
1. Generate all binary strings of length n (total = 2^n).
2. Store them in a list.
3. Remove all strings that appear in nums.
4. Return any remaining string.

Time Complexity:
Generating strings → O(2^n * n)
Checking/removing → O(n)

Overall ≈ O(2^n * n)

Space Complexity:
O(2^n)
*/

import java.util.*;

class Find_Unique_Binary_String {

    public String findDifferentBinaryString2(String[] nums) {

        int n = nums.length;

        ArrayList<String> all = new ArrayList<>();

        generate(n, "", all);

        for(String s : nums){
            all.remove(s);
        }

        return all.get(0);
    }

    void generate(int n, String curr, ArrayList<String> all){

        if(curr.length() == n){
            all.add(curr);
            return;
        }

        generate(n, curr + "0", all);
        generate(n, curr + "1", all);

}



// ------------------------------------------------------------
// Approach 2: Optimal (Cantor Diagonal Trick)
// ------------------------------------------------------------
/*
Idea:
Construct a string that differs from nums[i] at position i.

For each i:
If nums[i][i] == '0' → choose '1'
If nums[i][i] == '1' → choose '0'

This guarantees the new string differs from every nums[i]
at least at index i.

Time Complexity: O(n)
Space Complexity: O(n)
*/


    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;

        char[] res = new char[n];

        for(int i = 0; i < n; i++){

            if(nums[i].charAt(i) == '0')
                res[i] = '1';
            else
                res[i] = '0';
        }

        return new String(res);
    }
}