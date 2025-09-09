package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.LCM_and_GCD;/*
LCM and GCD
Difficulty: Easy
-----------------
Given two numbers A and B, find:
1. LCM (Least Common Multiple)
2. GCD (Greatest Common Divisor)

Input:
------
T -> number of test cases
A B -> two integers for each test case

Output:
-------
For each test case, print:
LCM GCD
(with a single space in between)

Constraints:
------------
1 <= T <= 10^3
1 <= A, B <= 10^9

Example:
--------
Input:
2
5 10
14 8

Output:
10 5
56 2

Explanation:
------------
Case 1:
  gcd(5, 10) = 5
  lcm(5, 10) = (5 * 10) / gcd = 50 / 5 = 10
Case 2:
  gcd(14, 8) = 2
  lcm(14, 8) = (14 * 8) / gcd = 112 / 2 = 56

Approach:
---------
- Use Euclidean algorithm to compute gcd efficiently (O(log(min(A,B))))
- Compute lcm using the relationship: lcm(a, b) = (a / gcd(a, b)) * b
  (do division first to prevent overflow)

Time Complexity:
----------------
O(log(min(A,B))) per test case
*/

import java.util.*;

class GFG {
    // Euclidean Algorithm for GCD
    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            long A = sc.nextLong();
            long B = sc.nextLong();

            long g = gcd(A, B);
            long l = (A / g) * B; // prevent overflow

            sb.append(l).append(" ").append(g).append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }
}
