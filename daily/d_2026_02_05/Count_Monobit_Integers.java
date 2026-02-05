package DSA_Diary.daily.d_2026_02_05;
/*
 Count Monobit Integers

Problem Statement:
You are given an integer n.
An integer is called Monobit if all bits in its binary representation are the same.

Task:
Return the count of Monobit integers in the range [0, n] (inclusive).

Definition:
- "0"  → Monobit (all bits are 0)
- "1"  → Monobit
- "11" → Monobit (3)
- "111" → Monobit (7)
- Any other binary representation with mixed bits is NOT Monobit

Observation:
Monobit numbers are only:
1) 0
2) Numbers of the form (2^k - 1)
   Examples: 1, 3, 7, 15, 31, ...

So the problem reduces to:
- Always count 0
- Count how many numbers of the form (2^k - 1) are ≤ n
*/

public class Count_Monobit_Integers {
    public int countMonobit(int n) {

        // Count 0 (always Monobit)
        int count = 1;

        int k = 1;

        // Count numbers of the form (2^k - 1)
        while ((1 << k) - 1 <= n) {
            count++;
            k++;
        }

        return count;
    }
}
/*
Example 1:
Input: n = 1
Monobit numbers: 0, 1
Output: 2

Example 2:
Input: n = 4
Monobit numbers: 0, 1, 3
Output: 3
*/
