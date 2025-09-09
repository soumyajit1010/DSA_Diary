package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Remove_common_characters_and_concatenate_OldP;/*
Remove common characters and concatenate OldP
Difficulty: Basic
Accuracy: 48.05%
Points: 1

Two strings are given. Modify the 1st string such that:
- All the common characters with the 2nd string are removed.
- Then, append the uncommon characters of the 2nd string to the end of the modified 1st string.

Note:
- If the resulting string is empty, print "-1".

Input:
The first line consists of an integer T (number of test cases).
For each test case:
    The first line consists of string s1.
    The second line consists of string s2.

Output:
For each test case, print the resulting string after modification.

Constraints: 
1 <= T <= 100
1 <= |Length of Strings| <= 100

Example:
Input:
2
aacdb
gafd
abcs
cxzca

Output:
cbgf
bsxz

Explanation:
Test case 1:
    s1 = "aacdb", s2 = "gafd"
    Common characters: {a, d}
    Remove from s1 → "cb"
    Remove from s2 → "gf"
    Concatenate → "cbgf"

Expected Time Complexity: O(n + m)  (where n = length of s1, m = length of s2)
Expected Space Complexity: O(k)    (where k = number of distinct characters)
*/

import java.util.*;

class GFG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine(); // consume newline

		while (T-- > 0) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();

			// Step 1: Find common characters
			Set<Character> common = new HashSet<>();
			for (char c : s2.toCharArray()) {
				if (s1.indexOf(c) != -1) {
					common.add(c);
				}
			}

			// Step 2: Remove from s1
			StringBuilder s1new = new StringBuilder();
			for (char c : s1.toCharArray()) {
				if (!common.contains(c)) {
					s1new.append(c);
				}
			}

			// Step 3: Remove from s2
			StringBuilder s2new = new StringBuilder();
			for (char c : s2.toCharArray()) {
				if (!common.contains(c)) {
					s2new.append(c);
				}
			}

			// Step 4: Concatenate
			String result = s1new.toString() + s2new.toString();
			if (result.isEmpty()) {
				System.out.println("-1");
			} else {
				System.out.println(result);
			}
		}
		sc.close();
	}
}

/*
Time Complexity: O(n + m)
- O(m) to build the set of common characters (checking indexOf in O(n) per char would be slower; here we use HashSet for O(1) lookup)
- O(n) to filter s1
- O(m) to filter s2
Overall: O(n + m)

Space Complexity: O(k)
- O(k) for the HashSet storing common characters (k ≤ 26 for lowercase alphabets or ≤256 for extended ASCII)
- O(n + m) space for the StringBuilders in worst case
*/
