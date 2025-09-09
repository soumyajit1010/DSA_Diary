package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Maximize_OR_OldP;/*
Maximize OR OldP
Difficulty: Basic
Accuracy: 23.69%

Problem:
Given a number X, find the total number of integers A such that:
    (A OR X) > X
and
    1 <= A <= X

Input:
- First line: T (number of test cases)
- Next T lines: each contains an integer X

Output:
- For each X, output the total count of A satisfying the condition.

Constraints:
1 <= T <= 10^5
1 <= X <= 10^8

Example:
Input:
2
10
5
Output:
7
2

Explanation:
For X = 10 (binary 1010), possible A in [1..10]:
1(0001), 3(0011), 4(0100), 5(0101), 6(0110), 7(0111), 9(1001) 
Total = 7

Logic:
- A OR X > X happens if A has a bit set in a position where X has 0.
- In binary, let zeroBits = number of positions where X has 0 (below the highest set bit).
- Each zero bit can be either 0 or 1 in A, except all zero bits can't be 0 (else OR equals X).
- So count = (2^(zeroBits) - 1) + all numbers above X with different bits? No — only consider A ≤ X.
- Simpler method: count numbers from 1 to X such that (A|X) > X.
- We can find directly: total = X - (2^(number_of_1_bits_positions) - 1 where all 1 positions match X and others 0) => Actually formula is X - (2^(countOneBits) - 1)

Optimized Trick:
Count numbers A in [1..X] where (A | X) == X (these don't work), subtract from X.
These A's must have 0 in all bit positions where X has 0.
So allowed positions = positions of 1's in X => count = 2^(countOneBits) - 1 (exclude A=0)
Answer = X - (2^(countOneBits) - 1)

Time Complexity:
O(1) per test case (bit counting)
Space Complexity:
O(1)
*/

import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int X = sc.nextInt();
            int oneBits = Integer.bitCount(X); // count of 1 bits in X
            int badCount = (1 << oneBits) - 1; // all A that don't increase OR
            int ans = X - badCount;
            sb.append(ans).append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
}
