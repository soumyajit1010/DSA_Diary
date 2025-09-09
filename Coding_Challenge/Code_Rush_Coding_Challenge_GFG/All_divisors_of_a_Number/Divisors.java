package DSA_Q.x.Code_Rush_Coding_Challenge_GFG.All_divisors_of_a_Number;/*
    All divisors of a Number
    Difficulty: Easy
    Accuracy: 46.73%
    Submissions: 71K+
    Points: 2
    Average Time: 10m

    Given an integer n, print all the divisors of N in ascending order.

    Examples:
    Input: n = 20
    Output: 1 2 4 5 10 20
    Explanation: 20 is completely divisible by 1, 2, 4, 5, 10 and 20.

    Input: n = 21191
    Output: 1 21191
    Explanation: As 21191 is a prime number, it has only 2 factors (1 and the number itself).
*/

public class Divisors {

    // Approach 1: Brute Force
    // Time Complexity: O(n)
    public static void printDivisorsBruteForce(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Approach 2: Optimized using sqrt(n)
    // Time Complexity: O(√n)
    public static void printDivisorsOptimized(int n) {
        // First pass: collect smaller divisors
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        // Second pass: collect larger divisors in ascending order
        for (int i = (int)Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0 && i != n / i) {
                System.out.print(n / i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 20;

        System.out.println("Brute Force:");
        printDivisorsBruteForce(n);  // Output: 1 2 4 5 10 20

        System.out.println("Optimized:");
        printDivisorsOptimized(n);   // Output: 1 2 4 5 10 20
    }
}
