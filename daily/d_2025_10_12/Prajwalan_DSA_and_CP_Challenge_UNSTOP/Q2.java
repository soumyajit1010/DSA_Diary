package DSA_Diary.daily.d_2025_10_12.Prajwalan_DSA_and_CP_Challenge_UNSTOP;
/*
📘 Problem Statement
---------------------------------------------------
You are given a string T (length between 3 and 10) that consists only of lowercase English letters.

The string contains exactly two different characters,
and only one of them appears exactly once.

Your task is to find and print the character that appears only once.

---------------------------------------------------
🔹 Input Format:
The input consists of a single line: T

🔹 Output Format:
Print the character that appears only once in the string.

---------------------------------------------------
🔹 Sample Test Case 1:
Input:
pop

Output:
o
(Explanation: 'o' appears once, 'p' appears twice.)

🔹 Sample Test Case 2:
Input:
zzzzt

Output:
t
(Explanation: 'z' appears 4 times, 't' appears once.)

🔹 Sample Test Case 3:
Input:
bba

Output:
a
(Explanation: 'a' appears once, 'b' appears twice.)
---------------------------------------------------
✅ Approach:
1. Count frequency of each character using an array or HashMap.
2. Traverse the string again to find the character whose count is 1.
3. Print that character.

---------------------------------------------------
⏱️ Time Complexity: O(n)
🧠 Space Complexity: O(1) — since there are only 26 lowercase letters.
---------------------------------------------------
*/

import java.util.*;

class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String T = sc.next();

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : T.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Find and print the character appearing once
        for (char ch : T.toCharArray()) {
            if (freq[ch - 'a'] == 1) {
                System.out.println(ch);
                break;
            }
        }
    }
}

class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String T = sc.next();  // read the input string
        sc.close();

        // Loop through each character
        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            // if first index == last index → appears only once
            if (T.indexOf(ch) == T.lastIndexOf(ch)) {
                System.out.println(ch);
                return;
            }
        }
    }
}
/*
Time Complexity (TC)	O(n²)	Because indexOf + lastIndexOf inside loop
Space Complexity (SC)	O(1)    No extra data structures used
 */

public class Q2 {
}
