package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.Series_GP;/*
Series GP
Difficulty: Easy
Given three integers a, r, and n, where:
- a is the first term of a geometric progression (GP),
- r is the common ratio,
- n is the term number to find.

Return the nth term of the GP modulo 1000000007 (1e9 + 7).

Examples:

Input: a = 2, r = 2, n = 4
Output: 16
Explanation: The GP series is 2, 4, 8, 16,... → 4th term is 16.

Input: a = 4, r = 3, n = 3
Output: 36
Explanation: The GP series is 4, 12, 36,... → 3rd term is 36.
*/

class Solution {
    public int nthTerm(int a, int r, int n) {
        int mod = 1000000007;

        // Recursive function inside main method using anonymous inner function is not possible,
        // so we simulate recursion manually within the method like this:
        return (int)((a * modExp(r, n - 1, mod)) % mod);
    }

    // Recursive exponentiation method inside the same class, but required as part of solution.
    private long modExp(long base, int exp, int mod) {
        if (exp == 0) return 1;
        long half = modExp(base, exp / 2, mod);
        long result = (half * half) % mod;
        if (exp % 2 == 1) result = (result * base) % mod;
        return result;
    }
}
