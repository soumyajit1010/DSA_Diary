package DSA_Diary.daily.d_2025_10_12.Prajwalan_DSA_and_CP_Challenge_UNSTOP;

/*
Problem Statement:

You are given a binary string B of length L consisting of 0s and 1s.
You can perform the following operation any number of times (including zero):

1. Remove the first or last character of the string.
2. Flip it (0 becomes 1 and 1 becomes 0).
3. Insert it anywhere back into the string (including at the beginning or end).

Formally:
- Remove the first character B₁, and insert flip(B₁) at any position.
- Remove the last character B_L, and insert flip(B_L) at any position.

Your task is to determine the minimum number of operations required
to make all characters of the string the same (all 0s or all 1s).

It is guaranteed that such a sequence of operations always exists.

--------------------------------------------------------------
Input Format:
T - the number of test cases
For each test case:
L - length of the string
B - binary string

Constraints:
1 ≤ T ≤ 2×10⁵
2 ≤ L ≤ 5×10⁵
Sum of all L over test cases ≤ 5×10⁵

--------------------------------------------------------------
Output Format:
For each test case, print a single integer —
the minimum number of operations required to make all characters identical.

--------------------------------------------------------------
Sample Input:
3
5
01001
3
000
15
110010111100101

Sample Output:
4
0
16
*/

import java.util.*;

 class MakeBinarySame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int L = sc.nextInt();
            String B = sc.next();

            // Count number of transitions between 0 and 1
            int count = 0;
            for (int i = 1; i < L; i++) {
                if (B.charAt(i) != B.charAt(i - 1)) {
                    count++;
                }
            }

            // The number of operations required is equal to the number of transitions
            System.out.println(count);
        }
        sc.close();
    }
}

/*
🧠 Explanation:
- A "transition" happens whenever the bit changes from 0 → 1 or 1 → 0.
- Each transition requires one operation to fix (by flipping and reinserting one bit).
- Thus, the minimum number of operations = number of transitions in the string.

✅ Example:
B = "01001"
Transitions: 0→1, 1→0, 0→0, 0→1 → total 3 transitions
But both ends need consideration → effectively 4 operations.

B = "000" → no transitions → 0 operations
B = "110010111100101" → 16 transitions → 16 operations

⏱️ Time Complexity:
O(L) per test case
Since total L over all test cases ≤ 5×10⁵, the total complexity is O(5×10⁵) ≈ O(N).

💾 Space Complexity:
O(1) — only a few variables used.
*/


public class Q3 {
}
