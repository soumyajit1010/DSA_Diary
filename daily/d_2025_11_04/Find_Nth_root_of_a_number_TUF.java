/*
💡 Problem: Find Nth Root of a Number

📝 Description:
Given two numbers N and M, find the Nth root of M.
The Nth root of a number M is defined as a number X such that:
        X^N = M
If the Nth root is not an integer, return -1.

-----------------------------------------
🧠 Examples:
Input:  N = 3, M = 27
Output: 3
Explanation: 3^3 = 27 → cube root is 3

Input:  N = 4, M = 69
Output: -1
Explanation: 4th root of 69 does not exist as an integer
-----------------------------------------

🕒 Time Complexity:
➡ Brute Force:  O(M * log N)   (for each i, power calculation up to N)
➡ Optimized:    O(N * log M)   (binary search + exponent loop)

🧮 Space Complexity: O(1)
*/

package DSA_Diary.daily.d_2025_11_04;

public class Find_Nth_root_of_a_number_TUF {

    // 🧩 Brute Force Approach
    public int NthRoot_BruteForce(int N, int M) {
        for (int i = 1; i <= M; i++) {
            int power = function(i, N);
            if (power == M) return i;
            if (power > M) break; // optimization to stop early
        }
        return -1;
    }

    // Helper function to calculate x^n using fast exponentiation
    public int function(int x, int n) {
        long ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                n--;
            } else {
                x = x * x;
                n /= 2;
            }
            if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE; // prevent overflow
        }
        return (int) ans;
    }

    // ⚙️ Optimized Binary Search Approach
    public int NthRoot_Optimized(int n, int m) {
        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midN = func(mid, n, m);

            if (midN == 1) return mid;      // Found nth root
            else if (midN == 0) low = mid + 1; // mid^n < m → move right
            else high = mid - 1;               // mid^n > m → move left
        }

        return -1; // no integer nth root exists
    }

    // Helper to compare mid^n with m
    public int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m) return 2; // mid^n > m
        }
        if (ans == m) return 1;     // mid^n == m
        return 0;                   // mid^n < m
    }

    // 🧾 Example test cases
    public static void main(String[] args) {
        Find_Nth_root_of_a_number_TUF obj = new Find_Nth_root_of_a_number_TUF();

        System.out.println("Brute Force → " + obj.NthRoot_BruteForce(3, 27)); // 3
        System.out.println("Brute Force → " + obj.NthRoot_BruteForce(4, 69)); // -1

        System.out.println("Optimized → " + obj.NthRoot_Optimized(3, 27)); // 3
        System.out.println("Optimized → " + obj.NthRoot_Optimized(4, 69)); // -1
    }
}
